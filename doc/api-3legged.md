# document-biz-3legged API

| URL                                                | Method           | Request Body       | Response Body                    | Function         |
| :-------------                                     | :-------------   | :-------------     | :-------------                   | :-------------   |
| [/co/document/create](#documentcreate)                | POST             | [{doc}](#document-entity-doc)  | {docUUID}            | 创建文档          |
| [/co/document/get](#documentget)                      | GET              | {docUUID}          | {doc}                            | 获取文档          |

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
        ... // Document Entity
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
            "documentUUID": "b5b7ff48-7921-4c5b-917c-e0ae9fc73d58"
        },
        "ok": true
    }
    ```
    
    > 参数非法 示例
    ```json5
    {
        "status": {
            "time": 1538039693498,
            "returnCode": "70400",
            "message": "invalid request parameter",
            "description": "权限校验失败：文档发送方非当前用户",
            "serviceCode": "document-service"
        },
        "body": null,
        "ok": false
    }
    ```
        
## /document/get

- Request

    > Query string
    ```
    ?uuid=ffffffff-ffff-ffff-ffff-ffffffffffff
    ```

- Response

    > 正常返回
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": {
            .../ Document entity
        },
        "ok": true
    }
    ```
    
    > 异常返回 示例
    ```json5
    {
        "status": {
            "time": 1538039525223,
            "returnCode": "70404",
            "message": "Document not found",
            "description": "单据不存在",
            "serviceCode": "document-service"
        },
        "body": null,
        "ok": false
    }
    ```
    
## Document Entity (`{doc}`)

- Order Sample (JSON)
    ```json5
    {
        "DocumentType": "DespatchAdvice",
        "ID": "DA-X12",
        "IssueDate": 1537259355768,
        "DespatchSupplierParty": {
            "ID": "4f025712-b650-4e97-a370-f4f162226106",
            "Name": "未来科技"
        },
        "DespatchSupplierContact": null,
        "DeliveryCustomerParty": {
            "ID": "bb15da22-b890-4ceb-b830-d42c3676a855",
            "Name": "深圳天宏迅联科技发展有限公司"
        },
        "DeliveryCustomerContact": null,
        "Lines": [
            {
                "ReceiveAddressNo": null,
                "ReceiveAddress": null,
                "ReceiveFactoryNo": null,
                "ReceiveFactory": null,
                "DocumentReference": null,
                "LineReference": null,
                "DocumentReference2": null,
                "LineReference2": null,
                "ID": "1",
                "Name": null,
                "ModelName": null,
                "BuyersProductID": 0,
                "BuyersItemIdentification": null,
                "BuyersItemName": null,
                "BuyersItemModelName": null,
                "SellersProductID": 0,
                "SellersItemIdentification": null,
                "SellersItemName": null,
                "SellersItemModelName": null,
                "SupplierBatchNumber": null,
                "DespatchQualityCheckResult": null,
                "StockBatchNumber": null,
                "QualityCheckReceiptNo": null,
                "UnitCode": null,
                "OrderedQuantity": null,
                "DeliveredQuantity": null,
                "BackorderQuantity": null,
                "OutstandingQuantity": null,
                "Description": null
            }
        ],
        "DeliveryAddress": null,
        "DeliveryContact": null,
        "DeliveryDate": null,
        "TransportModeCode": null,
        "TransportMeansTrackingID": null,
        "PerformingCarrierPartyContact": null,
        "CarrierParty": null,
        "Note": null,
        "Attachments": []
    }
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
