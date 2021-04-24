package com.asset.management.asset.controller;

import java.util.Collections;
import java.util.List;
import com.asset.management.asset.dao.graph.NodeType;
import com.asset.management.asset.model.MarketValueDTO;
import com.asset.management.asset.service.MarketValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/value")
public class MarketValueController
{
  private static final List<String> EMPTY_LIST = Collections.emptyList();

  private final MarketValueService itsMarketValueService;

  public MarketValueController(MarketValueService itsMarketValueService)
  {
    this.itsMarketValueService = itsMarketValueService;
  }

  @GetMapping("/investors/{investor}")
  public ResponseEntity<MarketValueDTO> marketValueOfInvestor(@PathVariable(name = "investor") String theInvestorName,
      @RequestParam(name = "exclude", required = false) List<String> theExcluded)
  {
    theExcluded = preProcess(theExcluded);
    return ResponseEntity.status(HttpStatus.OK)
        .body(MarketValueDTO.create(NodeType.INVESTOR,
            itsMarketValueService.marketValueCalculator(theInvestorName, NodeType.INVESTOR,
                theExcluded)));
  }


  @GetMapping("/funds/{fund}")
  public ResponseEntity<MarketValueDTO> marketValueOfFund(@PathVariable(name = "fund") String theFundName,
      @RequestParam(name = "exclude", required = false) List<String> theExcluded)
  {
    theExcluded = preProcess(theExcluded);
    return ResponseEntity.status(HttpStatus.OK)
        .body(MarketValueDTO.create(NodeType.FUND,
            itsMarketValueService.marketValueCalculator(theFundName,NodeType.FUND,
                theExcluded)));
  }

  private List<String> preProcess(List<String> theExcluded)
  {
    if(theExcluded == null)
      return EMPTY_LIST;
    return theExcluded;
  }
}
