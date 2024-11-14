var PortfolioApp = window.PortfolioApp || {};

// api gateway creation tutorial:
//      1.  create API
//      2.  REST api
//      3.  api endpoint type: Edge-optimized
//      4.  create
//      5.  create resource
//      6.  proxy resource: ON
//      7.  resource path: /
//      8.  resource name: {proxy+}
//      9.  create resource
//      10. any
//      11. edit integration
//      12. Lambda function
//      13. Lambda proxy integration: ON
//      14. choose a lambda function: [your lambda function]
//      15. save
//      16. test

// CORS tutorial:
//      1. click on /{proxy+}
//      2. enable CORS
//      3. check "Default 4XX" and "Default 5XX"
//      4. save

// Deploy tutorial:
//      1. deploy api
//      2. stage: *new stage*
//      3. stage name: prod [or name]
//      4. deploy

// API Gateway -> APIs -> [name of project] -> stages -> invoke url
PortfolioApp.apiEndpoint = 'https://pq9fi4niyb.execute-api.us-east-1.amazonaws.com/prod';