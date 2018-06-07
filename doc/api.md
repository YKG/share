# Document API

| URL                                                | Method           | Request Body       | Response Body                    | Function         |
| :-------------                                     | :-------------   | :-------------     | :-------------                   | :-------------   |
| [/document/create](#documentcreate)                | POST             | [{doc}](#document-entity-doc)  | {docUUID}            | 创建文档          |
| [/document/get](#documentget)                      | GET              | {docUUID}          | {doc}                            | 获取文档          |
| [/document/send](#documentsend)                    | POST             | {docUUID, doc}     | {docStatus}                      | 发送文档          |
| [/document/status/get](#documentstatusget)         | GET              | {docUUID}          | {docStatus}                      | 获取文档状态      |
| [/document//status/update](#documentstatusupdate)  | POST             | {docUUID, docStatus} | {status}                       | 更新文档状态      |
| [/document/query](#documentquery)                  | GET              | {queryParam}       | [{docInfoList}](#document-info-entity-docinfo) | 获取文档列表  |
| [/document/convert](#documentconvert)              | POST             | {doc, toDocType}   | {doc}                            | 文档转换          |


## I/O Convention

- Entities Table

    | Entity                    | Description            | JSON Type       | Sample                   | 
    | -------------             | -------------          |-------------    |-------------             |
    | [{doc}](#document-entity-doc) | Document Entity    | object          |                          | 
    | [{docInfo}](#document-info-entity-docinfo) | Document Info | object  |                          | 
    | {docUUID}                 | Document UUID          | string(uuid)    | `85aac415-73bd-480f-85b7-70ed1cec6506` | 
    | {docStatus}               | Document Status        | string          | `ACCEPTED` / `REJECTED`  | 
    | {docInfoList}             | Document Info List     | array           |                          | 
    | {toDocType}               | Document Type          | string          | `Order` / `Invoice`      | 

- 所有请求的响应码都是 `200`，异常响应的错误码放在响应体中

## /document/create

- Request
    ```json5
    {
      "body": {
        ... // Document Entity
      }
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
     "errCode": 0,
     "body": {
       "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff"
     }
    }
    ```
    
    > 参数非法 示例
    ```json5
    {
      "errCode": 400,
      "body": {
        "errMsg": "请求参数非法"
      }
    }
    ```
        
## /document/get

- Request
    ```json5
    {
      "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff"
    }
    ```

- Response

    > 正常返回
    ```json5
    {
     "errCode": 0,
     "body": {
       ... // Document Entity
     }
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
      "errCode": 404,
      "body": {
        "errMsg": "文档没有找到"
      }
    }
    ```
            
## /document/send

- Request
    ```json5
    {
      "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff"
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
     "errCode": 0,
     "body": {
       "documentStatus": "SENT"
     }
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
      "errCode": 404,
      "body": {
        "errMsg": "文档没有找到"
      }
    }
    ```            

## /document/status/get

- Request
    ```json5
    {
      "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff"
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
     "errCode": 0,
     "body": {
        "documentStatus": "ACCEPTED"
     }
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
      "errCode": 404,
      "body": {
        "errMsg": "文档没有找到"
      }
    }
    ```
    
## /document/status/update

- Request
    ```json5
    {
      "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff",
      "documentStatus": "ACCEPTED"
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
     "errCode": 0,
     "body": {
        "documentStatus": "ACCEPTED"
     }
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
      "errCode": 404,
      "body": {
        "errMsg": "文档没有找到"
      }
    }
    ```
    
## /document/query

- Request
    > 请求 示例
    ```json5
    {
      "param1": "param1 value",
      "param2": "param2 value",
      "param3": "param3 value",
      ...
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
     "errCode": 0,
     "body": [
        {
            "documentUUID": "704e90ab-84e6-431f-b051-b8b2d1ee1015",
            "tenantID": "122d17aa-35db-4aea-a74e-9de7deb13b33",
            "postedAt": "2018-06-04T10:09:37.071+08:00",
            "status": "SENT",
            "ID": "1001",
            "sender": "SenderParty Name",
            "receiver": "ReceiverParty Name",
            "TotalAmount": 234,
            "TaxTotalAmount": 34,
            "docType": "Order"
        },
        {
            "documentUUID": "76543210-84e6-431f-b051-b8b2d1ee1017",
            "tenantID": "122d17aa-35db-4aea-a74e-9de7deb13b33",
            "postedAt": "2018-06-05T10:09:38.071+08:00",
            "status": "SENT",
            "ID": "1002",
            "sender": "SenderParty Name",
            "receiver": "ReceiverParty Name",
            "TotalAmount": 117,
            "TaxTotalAmount": 117,
            "docType": "Order"
        }
     ]
    }
    ```
    
## /document/convert

- Request
    > 请求 示例
    ```json5
    {
      "toDocType": "Invoice",
      "body": {
        ... // Order Document Entity
      }
    }
    ```

- Response

    > 正常返回
    ```json5
    {
     "errCode": 0,
     "body": {
       ... // Invoice Document Entity
     }
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
      "errCode": 400,
      "body": {
        "errMsg": "文档格式校验失败"
      }
    }
    ```


## Document Entity (`{doc}`)

- Order Sample (JSON)
    ```json5
    {
        "Order": {
            "ID": {
                "value": "1006"
            },
            "IssueDate": "2018-06-06",
            "Note": {
                "value": "note"
            },
            "BuyerCustomerParty": {
                "Party": {
                    "PartyIdentification": {
                        "ID": {
                            "value": "122d17aa-35db-4aea-a74e-9de7deb13b33"
                        }
                    },
                    "PartyName": {
                        "Name": {
                            "value": "SenderParty"
                        }
                    }
                }
            },
            "SellerSupplierParty": {
                "Party": {
                    "PartyIdentification": {
                        "ID": {
                            "value": "222d17aa-35db-4aea-a74e-9de7deb13b33"
                        }
                    },
                    "PartyName": {
                        "Name": {
                            "value": "ReceiverParty"
                        }
                    }
                }
            },
            "Delivery": {
                "DeliveryLocation": {
                    "Address": {
                        "StreetName": {
                            "value": "XingHu Street"
                        }
                    }
                }
            },
            "TaxTotal": {
                "TaxAmount": {
                    "value": 17,
                    "currencyID": "CNY"
                }
            },
            "AnticipatedMonetaryTotal": {
                "LineExtensionAmount": {
                    "value": 200,
                    "currencyID": "CNY"
                },
                "TaxExclusiveAmount": {
                    "value": 34,
                    "currencyID": "CNY"
                },
                "TaxInclusiveAmount": {
                    "value": 234,
                    "currencyID": "CNY"
                },
                "PayableAmount": {
                    "value": 234,
                    "currencyID": "CNY"
                }
            },
            "OrderLine": [
                {
                    "LineItem": {
                        "ID": {
                            "value": "101"
                        },
                        "Quantity": {
                            "value": 1,
                            "unitCode": "EA"
                        },
                        "LineExtensionAmount": {
                            "value": 100,
                            "currencyID": "CNY"
                        },
                        "TotalTaxAmount": {
                            "value": 17,
                            "currencyID": "CNY"
                        },
                        "Price": {
                            "PriceAmount": {
                                "value": 100,
                                "currencyID": "CNY"
                            }
                        },
                        "Item": {
                            "Name": {
                                "value": "MacBook Air"
                            }
                        }
                    }
                },
                {
                    "LineItem": {
                        "ID": {
                            "value": "102"
                        },
                        "Quantity": {
                            "value": 1,
                            "unitCode": "EA"
                        },
                        "LineExtensionAmount": {
                            "value": 100,
                            "currencyID": "CNY"
                        },
                        "TotalTaxAmount": {
                            "value": 17,
                            "currencyID": "CNY"
                        },
                        "Price": {
                            "PriceAmount": {
                                "value": 100,
                                "currencyID": "CNY"
                            }
                        },
                        "Item": {
                            "Name": {
                                "value": "MacBook Pro"
                            }
                        }
                    }
                }
            ]
        }
    }
    ```

- Order Sample (XML)
    ```xml
  <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <Order>
        <ID>1006</ID>
        <IssueDate>2018-06-06</IssueDate>
        <Note>note</Note>
        <BuyerCustomerParty>
            <Party>
                <PartyIdentification>
                    <ID>122d17aa-35db-4aea-a74e-9de7deb13b33</ID>
                </PartyIdentification>
                <PartyName>
                    <Name>SenderParty</Name>
                </PartyName>
            </Party>
        </BuyerCustomerParty>
        <SellerSupplierParty>
            <Party>
                <PartyIdentification>
                    <ID>222d17aa-35db-4aea-a74e-9de7deb13b33</ID>
                </PartyIdentification>
                <PartyName>
                    <Name>ReceiverParty</Name>
                </PartyName>
            </Party>
        </SellerSupplierParty>
        <Delivery>
            <DeliveryLocation>
                <Address>
                    <StreetName>xinghu s.t.</StreetName>
                </Address>
            </DeliveryLocation>
        </Delivery>
        <TaxTotal>
            <TaxAmount currencyID="CNY">17.00</TaxAmount>
        </TaxTotal>
        <AnticipatedMonetaryTotal>
            <LineExtensionAmount currencyID="CNY">200.00</LineExtensionAmount>
            <TaxExclusiveAmount currencyID="CNY">34.00</TaxExclusiveAmount>
            <TaxInclusiveAmount currencyID="CNY">234.00</TaxInclusiveAmount>
            <PayableAmount currencyID="CNY">234.00</PayableAmount>
        </AnticipatedMonetaryTotal>
        <OrderLine>
            <LineItem>
                <ID>101</ID>
                <Quantity unitCode="EA">1.00</Quantity>
                <LineExtensionAmount currencyID="CNY">100.00</LineExtensionAmount>
                <TotalTaxAmount currencyID="CNY">17.00</TotalTaxAmount>
                <Price>
                    <PriceAmount currencyID="CNY">100.00</PriceAmount>
                </Price>
                <Item>
                    <Name>MacBook Air</Name>
                </Item>
            </LineItem>
        </OrderLine>
        <OrderLine>
            <LineItem>
                <ID>102</ID>
                <Quantity unitCode="EA">1.00</Quantity>
                <LineExtensionAmount currencyID="CNY">100.00</LineExtensionAmount>
                <TotalTaxAmount currencyID="CNY">17.00</TotalTaxAmount>
                <Price>
                    <PriceAmount currencyID="CNY">100.00</PriceAmount>
                </Price>
                <Item>
                    <Name>MacBook Pro</Name>
                </Item>
            </LineItem>
        </OrderLine>
    </Order>
    ```

## Document Info Entity (`{docInfo}`)

- Sample
    ```json5
    {
        "documentUUID": "704e90ab-84e6-431f-b051-b8b2d1ee1015",
        "tenantID": "122d17aa-35db-4aea-a74e-9de7deb13b33",
        "postedAt": "2018-06-04T10:09:37.071+08:00",
        "status": "SENT",
        "ID": "1001",
        "sender": "SenderParty Name",
        "receiver": "ReceiverParty Name",
        "TotalAmount": 234,
        "TaxTotalAmount": 34,
        "docType": "Order"
    }
    ```
