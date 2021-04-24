<h1><i><b>Asset Management Coding Exercise</b></i></h1>

<h2><b>Coding Expectation</b><h2>
<ol>
<li>System should able to add the investors, funds, and Holdings.</li>
<li>System should allow the investors to invest in any funds.</li>
<li>System should allow the fund house to invest in any holdings with any number of quantity.</li>
<li>System should be able to calculate the market value of any Investor and Funds</li>
<li>System should also allow to Exclude some funds or holdings when calculating the market value of an Investor</li>
<li>System should also allow to Exclude some holdings when calculating the market value of a Fund</li>
</ol>

<h2><b>System APIs</b></h2>
<hr>
<h4>API for Investor to Invest in Fund</h4>

```java
POST http://localhost:8080/invests/investors  201 Created
Request Body

    {
    "investor": {
    "name": "INV1"
    },
    "fund": {
    "fundName": "F1"
    }
    }
```

<h4>API for Funds to Invest in Holdings</h4>

```java
POST http://localhost:8080/invests/funds  201 Created

Request Body

    {
    "fund": {
    "fundName": "F3"
    },
    "holding": {
    "name": "H4",
    "value": 10
    },
    "quantity": 100
    }
```

<h4>API for calculating the Market Value of Investor</h4>
```java
GET http://localhost:8080/value/investors/{investor}?&exclude={holdingName1}&exclude={holdingName2} 200 OK

Response Body

    {
      "type":"INVESTOR",
      "value":6000
    }

```
<h4>API for calculating the Market value of Fund</h4>
```java
GET http://localhost:8080/value/funds/{fund}?&exclude={holdingName1}&exclude={holdingName2} 200 OK

    {
    "type":"FUND",
    "value":6500
    }
```



