# Document API

| URL                                                | Method           | Request Body       | Response Body                    | Function         |
| :-------------                                     | :-------------   | :-------------     | :-------------                   | :-------------   |
| [/document/create](#documentcreate)                | POST             | [{doc}](#document-entity-doc)  | {docUUID}            | 创建文档          |
| [/document/get](#documentget)                      | GET              | {docUUID}          | {doc}                            | 获取文档          |
| [/document/send](#documentsend)                    | POST             | {docUUID, doc}     | {docStatus}                      | 发送文档          |
| [/document/status/get](#documentstatusget)         | GET              | {docUUID}          | {docStatus}                      | 获取文档状态      |
| [/document//status/update](#documentstatusupdate)  | POST             | {docUUID, docStatus} | {docStatus}                    | 更新文档状态      |
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
        "status": {
            "returnCode": "200"
        },
        "body": {
            "pageMeta": {
                "pageNum": 1,
                "pageSize": 3,
                "total": 11,
                "pages": 4
            },
            "items": [
                {
                    "documentUUID": "927e217b-ac2f-490b-9a7c-5c52f87d549b",
                    "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
                    "documentID": "DA-103310X",
                    "issueDate": 1530230400000,
                    "createTime": 1534212465692,
                    "lastModifyTime": 1534212465692,
                    "documentType": "DespatchAdvice",
                    "actualDocumentType": "DespatchAdvice",
                    "status": "DRAFT",
                    "allowedTargetStatus": [],
                    "role": "Seller",
                    "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
                    "counterparty": "未来科技",
                    "sender": "中科",
                    "receiver": "未来科技",
                    "isArchived": false
                },
                {
                    "documentUUID": "7162038f-2996-4f2c-b947-4c510b6ddb9f",
                    "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
                    "documentID": "DA-10310",
                    "issueDate": 1530230400000,
                    "createTime": 1534212433728,
                    "lastModifyTime": 1534212433728,
                    "documentType": "DespatchAdvice",
                    "actualDocumentType": "DespatchAdvice",
                    "status": "DRAFT",
                    "allowedTargetStatus": [],
                    "role": "Seller",
                    "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
                    "counterparty": "未来科技",
                    "sender": "中科",
                    "receiver": "未来科技",
                    "isArchived": false
                },
                {
                    "documentUUID": "1eaf4a55-6488-4fb9-87cf-598fc0a16ed7",
                    "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
                    "documentID": "DA-1031",
                    "issueDate": 1530230400000,
                    "createTime": 1532661905581,
                    "lastModifyTime": 1533627665884,
                    "documentType": "DespatchAdvice",
                    "actualDocumentType": "DespatchAdvice",
                    "status": "DRAFT",
                    "allowedTargetStatus": [],
                    "role": "Seller",
                    "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
                    "counterparty": "未来科技",
                    "sender": "中科",
                    "receiver": "未来科技",
                    "isArchived": false
                }
            ]
        },
        "ok": true
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
      "DocumentType": "DespatchAdvice",
      "DespatchAdviceNumber": "DA-103310X",
      "IssueDate": 1530230400000,
      "DespatchSupplierParty": {
        "ID": "bb15da22-b890-4ceb-b830-d42c3676a855",
        "Name": "中科"
      },
      "DespatchSupplierContact": {
        "ID": "33470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "张三" 
      },
      "DeliveryCustomerParty": {
        "ID": "4f025712-b650-4e97-a370-f4f162226106",
        "Name": "未来科技"
      },
      "DeliveryCustomerContact": {
        "ID": "55470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "王五"
      },
      "Lines": [
        {
          "ReceiveAddressNo" : "R1",
          "ReceiveAddress" : "ReceiveAddress01",
          "ReceiveFactoryNo" : "F1",
          "ReceiveFactory" : "FACTORY1",
          "DocumentReference": "PO-101",
          "LineReference": "1",
          "ID": "JFOE982FJO8",
          "Name": "铝液",
          "ModelName": "B-91",
          "UnitCode": "EA",
          "OrderedQuantity": 2,
          "DeliveredQuantity": 2,
          "Description": "发货描述"
        },
        {
          "ReceiveAddressNo" : "R2",
          "ReceiveAddress" : "ReceiveAddress02",
          "ReceiveFactoryNo" : "F2",
          "ReceiveFactory" : "FACTORY2",
          "DocumentReference": "PO-101",
          "LineReference": "2",
          "ID": "JFOE982FJO8",
          "Name": "铝液",
          "ModelName": "B-91",
          "UnitCode": "EA",
          "OrderedQuantity": 2,
          "DeliveredQuantity": 3,
          "Description": "发货描述"
        }
      ],
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
      "DeliveryDate": 1530230400000,
      "TransportModeCode": "TMC3", 
      "TransportMeansTrackingID": "渝A-123456", 
      "PerformingCarrierPartyContact": {
        "ID": "55470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "王五", 
        "Phone": "12345"
      },
      "CarrierParty": {
        "ID": "55470eea-545b-4d6e-b795-4aa73f25ed8a",
        "Name": "承运方"
      },
      "Note": "备注",
      "Attachments": [
      ]
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
        "documentUUID": "927e217b-ac2f-490b-9a7c-5c52f87d549b",
        "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
        "documentID": "DA-103310X",
        "issueDate": 1530230400000,
        "createTime": 1534212465692,
        "lastModifyTime": 1534212465692,
        "documentType": "DespatchAdvice",
        "actualDocumentType": "DespatchAdvice",
        "status": "DRAFT",
        "allowedTargetStatus": [],
        "role": "Seller",
        "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
        "counterparty": "未来科技",
        "sender": "中科",
        "receiver": "未来科技",
        "isArchived": false
    }
    ```
