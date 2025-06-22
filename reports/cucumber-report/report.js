$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:TestSuites/API/BookingAPISpec/AddBooking.feature");
formatter.feature({
  "name": "Add booking successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Set body \"\u003cbody\u003e\" to Add Booking API",
  "keyword": "Given "
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.step({
  "name": "Verify response data and \u003cstatusCode\u003e Add Booking API",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "body",
        "statusCode"
      ]
    },
    {
      "cells": [
        "fullValidData",
        "200"
      ]
    },
    {
      "cells": [
        "firstnameEmptyString",
        "200"
      ]
    },
    {
      "cells": [
        "firstnameNull",
        "500"
      ]
    },
    {
      "cells": [
        "lastnameNull",
        "500"
      ]
    },
    {
      "cells": [
        "lastnameEmptyString",
        "200"
      ]
    },
    {
      "cells": [
        "totalpriceIs0",
        "200"
      ]
    },
    {
      "cells": [
        "totalpriceNull",
        "500"
      ]
    },
    {
      "cells": [
        "depositpaidFalse",
        "200"
      ]
    },
    {
      "cells": [
        "depositpaidNull",
        "500"
      ]
    },
    {
      "cells": [
        "bookingdatesNull",
        "500"
      ]
    },
    {
      "cells": [
        "checkinNull",
        "500"
      ]
    },
    {
      "cells": [
        "checkoutNull",
        "500"
      ]
    },
    {
      "cells": [
        "addtionalneedsEmptyString",
        "200"
      ]
    },
    {
      "cells": [
        "addtionalneedsNull",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"fullValidData\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"firstnameEmptyString\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"firstnameNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"lastnameNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"lastnameEmptyString\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"totalpriceIs0\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"totalpriceNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"depositpaidFalse\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"depositpaidNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"bookingdatesNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"checkinNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"checkoutNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 500 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"addtionalneedsEmptyString\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a new booking success when invoke api add booking",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddBooking"
    },
    {
      "name": "@Booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"addtionalneedsNull\" to Add Booking API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.setBodyAddBooking(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add a new booking when invoke api add booking",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.sendRequestAddBooking()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and 200 Add Booking API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.BookingAPISteps.AddBookingAPISteps.verifyResponseAddBooking(int)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:TestSuites/API/ObjectsAPISpec/AddObject.feature");
formatter.feature({
  "name": "Add a object successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddObject"
    },
    {
      "name": "@Object"
    }
  ]
});
formatter.scenario({
  "name": "Add a object successfully when invoke api add object with full field json body",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddObject"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@PositiveTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"HappyCase\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add a object successfully with value name is null when invoke api add object with json body missing name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddObject"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@NegativeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"MissingName\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Expected status code 200 expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject(AddObjectAPISteps.java:54)\n\tat ✽.Create a new object when invoke api add object(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/AddObject.feature:13)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Add a object successfully with value data is null when invoke api add object with json body missing data object",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddObject"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@NegativeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"MissingData\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Expected status code 200 expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject(AddObjectAPISteps.java:54)\n\tat ✽.Create a new object when invoke api add object(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/AddObject.feature:19)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Add a object successfully when invoke api add object with value data random key-value",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@AddObject"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@NegativeTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"ValueDataRandomKey\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Expected status code 200 expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject(AddObjectAPISteps.java:54)\n\tat ✽.Create a new object when invoke api add object(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/AddObject.feature:25)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("file:TestSuites/API/ObjectsAPISpec/DeleteObject.feature");
formatter.feature({
  "name": "Delete object successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    }
  ]
});
formatter.scenario({
  "name": "Delete object success with id does exist when invoke api delete object",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@DeleteObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"HappyCase\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Object is deleted when invoke api delete object api with id does exist",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.DeleteObjectAPISteps.sendRequestDeleteObject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data after invoke delete object api",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.DeleteObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Unexpected server response.\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat StepDefinitions.ObjectsAPISteps.DeleteObjectAPISteps.verifyResponseData(DeleteObjectAPISteps.java:88)\n\tat ✽.Verify response data after invoke delete object api(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/DeleteObject.feature:10)\n",
  "status": "failed"
});
formatter.step({
  "name": "Receive data object when invoke api get object with id does exist",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDValid()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Show error when invoke delete object api with id doesn\u0027t exist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@DeleteObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Invoke api delete object api with id doesn\u0027t exist is \"gw345t34v54tvb324t32b4v5t\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.DeleteObjectAPISteps.sendRequestDeleteObjectWithID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data after invoke delete object api",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.DeleteObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Receive data object when invoke api get object with id doesn\u0027t exist is \"gw345t34v54tvb324t32b4v5t\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat org.testng.Assert.assertEquals(Assert.java:375)\n\tat StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(GetObjectAPISteps.java:83)\n\tat ✽.Receive data object when invoke api get object with id doesn\u0027t exist is \"gw345t34v54tvb324t32b4v5t\"(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/DeleteObject.feature:17)\n",
  "status": "failed"
});
formatter.uri("file:TestSuites/API/ObjectsAPISpec/GetObject.feature");
formatter.feature({
  "name": "Get info object successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    }
  ]
});
formatter.scenario({
  "name": "Get object by id does exist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@GetObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"HappyCase\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Expected status code 200 expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject(AddObjectAPISteps.java:54)\n\tat ✽.Create a new object when invoke api add object(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/GetObject.feature:7)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Receive data object when invoke api get object with id does exist",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDValid()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify response data and body Get Object API",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.verifyResponseGetObject()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Get object by id doesn\u0027t exist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@GetObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Receive data object when invoke api get object with id doesn\u0027t exist is \"thisidinvalid12345\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat org.testng.Assert.assertEquals(Assert.java:375)\n\tat StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(GetObjectAPISteps.java:83)\n\tat ✽.Receive data object when invoke api get object with id doesn\u0027t exist is \"thisidinvalid12345\"(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/GetObject.feature:14)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data Get Object API with id is invalid",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.verifyResponseGetObjectWithIdInvalid()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Get object by id is empty",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@GetObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Receive data object when invoke api get object with id doesn\u0027t exist is \"\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(java.lang.String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003c200\u003e but was:\u003c405\u003e\n\tat org.testng.Assert.fail(Assert.java:89)\n\tat org.testng.Assert.failNotEquals(Assert.java:480)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:365)\n\tat org.testng.Assert.assertEquals(Assert.java:375)\n\tat StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.sendRequestGetObjectWithIDInvalid(GetObjectAPISteps.java:83)\n\tat ✽.Receive data object when invoke api get object with id doesn\u0027t exist is \"\"(file:///Users/applemacmini/Documents/AutomationTesting/API/RestAssured/RestAssured_Automation_API/TestSuites/API/ObjectsAPISpec/GetObject.feature:19)\n",
  "status": "failed"
});
formatter.step({
  "name": "Verify response data Get Object API with id is invalid",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.GetObjectAPISteps.verifyResponseGetObjectWithIdInvalid()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("file:TestSuites/API/ObjectsAPISpec/UpdateObject.feature");
formatter.feature({
  "name": "Update object successfully",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@UpdateObject"
    },
    {
      "name": "@Object"
    }
  ]
});
formatter.scenario({
  "name": "Update data object success after create a object",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@RegressionTest"
    },
    {
      "name": "@UpdateObject"
    },
    {
      "name": "@Object"
    },
    {
      "name": "@UpdateObject"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Set body \"HappyCase\" to Add Object API",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.setBodyAddObjectAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create a new object when invoke api add object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.sendRequestAddObject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data and body Add Object API",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.AddObjectAPISteps.verifyResponseData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Data of object is updated when invoke api update object",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.UpdateObjectAPISteps.sendRequestUpdateObject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify response data is updated when invoke api update object",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.ObjectsAPISteps.UpdateObjectAPISteps.verifyResponseUpdateObject()"
});
formatter.result({
  "status": "passed"
});
});