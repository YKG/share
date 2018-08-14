# document-biz API - Archive Document


| URL                                                |  Function              |
| :-------------                                     | :-------------         |
| [/document/archive](#documentarchive)              | 归档/取消归档            |
| [/document/query](#documentquery)                  | 按是否已归档查询单据列表  |
| [/document/info/get](#documentinfoget)             | 查询单据是否已归档       |


        
## /document/archive

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
        "documentUUID": "2f8a8af4-e284-4bcb-b765-3f4dbe50374c",
        "archive": true                                         // true: archive ; false: unarchive
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": 1,
        "ok": true
    }
    ```
    
    > 参数非法 示例
    ```json5
    // TODO
    ```
  

## /document/query

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
    	"pageNum": 1,
    	"pageSize": 3,
    	"isArchived": true                                      // true: archive ; false: unarchive
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
                "total": 1,
                "pages": 1
            },
            "items": [
                {
                    "documentUUID": "5b963019-385e-454e-a464-ecd8d44573c7",
                    "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
                    "documentID": "DA-222222",
                    "issueDate": 1533600000000,
                    "createTime": 1533630526986,
                    "lastModifyTime": 1533630526997,
                    "documentType": "DespatchAdvice",
                    "actualDocumentType": "DespatchAdvice",
                    "status": "RECEIVED",
                    "allowedTargetStatus": [
                        "ACCEPTED",
                        "REJECTED"
                    ],
                    "role": "Buyer",
                    "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
                    "counterparty": "...",
                    "sender": "...",
                    "receiver": "...",
                    "isArchived": true
                }
            ]
        },
        "ok": true
    }
    ```


## /document/info/get

- Method
    ```
    GET
    ```

- QueryParam 示例
    ```
    uuid=5b963019-385e-454e-a464-ecd8d44573c7
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": {
            "documentUUID": "5b963019-385e-454e-a464-ecd8d44573c7",
            "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a855",
            "documentID": "DA-222222",
            "issueDate": 1533600000000,
            "createTime": 1533630526986,
            "lastModifyTime": 1533630526997,
            "documentType": "DespatchAdvice",
            "actualDocumentType": "DespatchAdvice",
            "status": "RECEIVED",
            "allowedTargetStatus": [
                "ACCEPTED",
                "REJECTED"
            ],
            "role": "Buyer",
            "counterpartyUUID": "4f025712-b650-4e97-a370-f4f162226106",
            "counterparty": "...",
            "sender": "...",
            "receiver": "...",
            "isArchived": true                                  // true: archive ; false: unarchive
        },
        "ok": true
    }
    ```
