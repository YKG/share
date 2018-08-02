# document-biz API 单据转换示例



## /document/transform/allowed-doc-type

- Method
    ```
    GET
    ```

- QueryParam 示例
    ```
    uuid=2f8a8af4-e284-4bcb-b765-3f4dbe50374c
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": [
            "ForecastDemand"
        ],
        "ok": true
    }
    ```
    
    > 参数非法 示例
    ```json5
    // TODO
    ```
        
        
## /document/transform

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
        "documentUUID": "2f8a8af4-e284-4bcb-b765-3f4dbe50374c",
        "toDocType": "DespatchAdvice"
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
            "documentUUID": "f3581a69-8b8b-4d45-b889-69cd839ff141"
        },
        "ok": true
    }
    ```
    
    > 参数非法 示例
    ```json5
    // TODO
    ```