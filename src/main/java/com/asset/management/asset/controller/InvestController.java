package com.asset.management.asset.controller;

import com.asset.management.asset.model.InvestInFunds;
import com.asset.management.asset.model.InvestInHolding;
import com.asset.management.asset.service.InvestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invests")
public class InvestController
{
  private static final Logger LOGGER = LoggerFactory.getLogger(InvestController.class);

  private final InvestService itsInvestorService;

  public InvestController(InvestService itsInvestorService)
  {
    this.itsInvestorService = itsInvestorService;
  }

  @PostMapping("/investors")
  public ResponseEntity<InvestInFunds> investorInvestToFund(@RequestBody InvestInFunds theInvestInFunds)
  {
    LOGGER.info("Got Request to Invest {}",theInvestInFunds);
    itsInvestorService.invest(theInvestInFunds);
    LOGGER.info("Invest {}",theInvestInFunds);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(theInvestInFunds);
  }

  @PostMapping("/funds")
  public ResponseEntity<InvestInHolding> fundInvestInHolding(@RequestBody InvestInHolding theInvestInHoldings)
  {
    LOGGER.info("Got Request to Invest {}",theInvestInHoldings);
    itsInvestorService.invest(theInvestInHoldings);
    LOGGER.info("Invest {}",theInvestInHoldings);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(theInvestInHoldings);
  }

}
