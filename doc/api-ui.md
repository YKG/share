# API for UI


- 草稿态下获取的 Order 示例

    > `单据级`扩展字段: `ExtraLineRemark2` 和 `ExtraLineRemark3`
    >
    > `单据行级`扩展字段: `ExtraLineRemark5` 和 `ExtraLineRemark6`

    ```json5
    {
    "body": {
      "DocumentType": "Order",
      "OrderNumber": "PO-101",
      "IssueDate": "2018/06/29",
      "DocumentCurrencyCode": "CNY",
      "BuyerCustomerParty": {
        "ID": "22470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "中科"
      },
      "BuyerContact": {
        "ID": "33470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "张三"
      },
      "SellerSupplierParty": {
        "ID": "44470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "供应商公司名"
      },
      "SellerContact": {
        "ID": "55470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "王五"
      },
      "RequestedDeliveryPeriod": {
        "StartDate": "2018/06/29",
        "EndDate": "2018/07/29"
      },
      "Total": 232323,
      "PaymentMeans": "PMZ01",
      "Note": "备注",
      "DeliveryAddress": {
        "Country": "CHN",
        "CountrySubentity": "重庆市",
        "CityName": "渝中区",
        "AddressLine": "华盛路1号企业天地8号楼33A"
      },
      "DeliveryContact": {
        "Name": "收货联系人姓名",
        "Phone": "132434345465"
      },
      "Attachments": [
        {
          "FileName": "ddfwwke.doc",
          "UUID": "3c470eea-545b-4d6e-b795-4aa73f25ed8a"
        },
        {
          "FileName": "附件2.doc",
          "UUID": "44470eea-545b-4d6e-b795-4aa73f25ed80"
        }
      ],
      "Lines": [
        {
          "ID": "JFOE982FJO8",
          "Name": "sss",
          "Quantity": 2,
          "LineExtensionAmount": 23,
          "ModelName": "dd",
          "Description": "描述",
          "UnitCode": "EA",
          "Price": 104656010.00,
          "ExtraLineRemark5": "DOC-5555",
          "ExtraLineRemark6": "DOCLINE-01"
        },
        {
          "ID": "JKOE982FJO8",
          "Name": "生石灰",
          "Quantity": 10,
          "LineExtensionAmount": 230,
          "ModelName": "白色",
          "Description": "描述详情",
          "UnitCode": "EA",
          "Price": 23.00,
          "ExtraLineRemark5": "DOC-5555",
          "ExtraLineRemark6": "DOCLINE-01"
        }
      ],
      "ExtraRemark2": "100吨",
      "ExtraRemark3": "2018-10-01"
    },
    "rules": {
        "Lines": {
        "Extra": {
            "ExtraLineRemark5": {
                "displayText": "行扩展字段5",
                "isRequired": true,
                "inputType": "TEXT",                                                 // 文本框
                "regex": "^\\w+$",
                "regexDescription": "字段名称regex",
                "invalidTip": "输入非法"
            },
            "ExtraLineRemark6": {
                "displayText": "行扩展字段6",
                "inputType": "SELECT",                                                   // 下拉列表
                "selectOptions": [{"key":"11","val":"32" }, {"key":"11","val":"32" }],   // 下拉列表键值对
                "invalidTip": "输入非法",
                "isRequired": true,
                "regexDescription": "字段名称regex",
                "regex": "^\\w+$"
            }
        }
        },
        "Extra": {
            "ExtraLineRemark2": {
                "displayText": "单据扩展字段2",
                "isRequired": true,
                "inputType": "TEXT",                                                     // 文本框
                "regex": "^\\w+$",
                "regexDescription": "字段名称regex",
                "invalidTip": "输入非法"
            },
            "ExtraLineRemark3": {
                "displayText": "单据扩展字段3",
                "inputType": "SELECT",   
                "selectOptions": [{"key":"11","val":"32" }, {"key":"11","val":"32" }],   // 下拉列表键值对
                "invalidTip": "输入非法",
                "isRequired": true,
                "regexDescription": "字段名称regex",
                "regex": "^\\w+$"
            }
        },
        "Note": {
          "regex": "^\\w{0,200}$"
          "regexDescription": "字段名称regex",
          "invalidTip": "输入非法"
        }
    },
    "ok": true,
    "status": {
        "time": 1536129504116,
        "returnCode": "200",
        "message": "ok",
        "description": "ok",
        "serviceCode": "document-service"
    }
    }
    ```


- 只读模式下（已发送/已接收之后）获取的 DespatchAdvice 示例

    > `单据级`扩展字段: `ExtraLineRemark2` 和 `ExtraLineRemark3`
    >
    > `单据行级`扩展字段: `ExtraLineRemark5` 和 `ExtraLineRemark6`
    
    ```json5
    {
    "body": {
      "DocumentType": "Order",
      "OrderNumber": "PO-101",
      "IssueDate": "2018/06/29",
      "DocumentCurrencyCode": "CNY",
      "BuyerCustomerParty": {
        "ID": "22470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "中科"
      },
      "BuyerContact": {
        "ID": "33470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "张三"
      },
      "SellerSupplierParty": {
        "ID": "44470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "供应商公司名"
      },
      "SellerContact": {
        "ID": "55470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "王五"
      },
      "RequestedDeliveryPeriod": {
        "StartDate": "2018/06/29",
        "EndDate": "2018/07/29"
      },
      "Total": 232323,
      "PaymentMeans": "PMZ01",
      "Note": "备注",
      "DeliveryAddress": {
        "Country": "CHN",
        "CountrySubentity": "重庆市",
        "CityName": "渝中区",
        "AddressLine": "华盛路1号企业天地8号楼33A"
      },
      "DeliveryContact": {
        "Name": "收货联系人姓名",
        "Phone": "132434345465"
      },
      "Attachments": [
        {
          "FileName": "ddfwwke.doc",
          "UUID": "3c470eea-545b-4d6e-b795-4aa73f25ed8a"
        },
        {
          "FileName": "附件2.doc",
          "UUID": "44470eea-545b-4d6e-b795-4aa73f25ed80"
        }
      ],
      "Lines": [
        {
          "ID": "JFOE982FJO8",
          "Name": "sss",
          "Quantity": 2,
          "LineExtensionAmount": 23,
          "ModelName": "dd",
          "Description": "描述",
          "UnitCode": "EA",
          "Price": 104656010.00,
          "ExtraLineRemark5": "DOC-5555",
          "ExtraLineRemark6": "DOCLINE-01"
        },
        {
          "ID": "JKOE982FJO8",
          "Name": "生石灰",
          "Quantity": 10,
          "LineExtensionAmount": 230,
          "ModelName": "白色",
          "Description": "描述详情",
          "UnitCode": "EA",
          "Price": 23.00,
          "ExtraLineRemark5": "DOC-5555",
          "ExtraLineRemark6": "DOCLINE-01"
        }
      ],
      "ExtraRemark2": "100吨",
      "ExtraRemark3": "2018-10-01"
    },
    "rules": {
        "Lines": {
            "Extra": {
                "ExtraLineRemark5": {
                    "displayText": "行扩展字段5",
                    "inputType": "TEXT"     // 要不要呢？
                },
                "ExtraLineRemark6": {
                    "displayText": "行扩展字段6",
                    "inputType": "SELECT"   // 要不要呢？
                }
            }
        },
        "Extra": {
            "ExtraLineRemark2": {
                "displayText": "单据扩展字段2"
            },
            "ExtraLineRemark3": {
                "displayText": "单据扩展字段3"
            }
        }
    },
    "ok": true,
    "status": {
        "time": 1536129504116,
        "returnCode": "200",
        "message": "ok",
        "description": "ok",
        "serviceCode": "document-service"
    }
    }
    ```