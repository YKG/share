# Document API


## DespatchAdviceSamle
```json5
{
  "DocumentType": "DespatchAdvice",                     // 文档类型
  "IssueDate": 1530230400000,                           // 填报日期
  // ...
}
```



## /document/create

- Request
    ```json5
    {
      "DocumentType": "DespatchAdvice",                // 文档类型
      "IssueDate": 1530230400000,                      // 填报日期
      // ...
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
            "documentUUID": "ffffffff-ffff-ffff-ffff-ffffffffffff"
        }
    }
    ```
    
    > 参数非法 示例
    ```json5
    // TODO
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
          "DocumentType": "DespatchAdvice",                // 文档类型
          "IssueDate": 1530230400000,                      // 填报日期
          // ...
    }
    ```
    
    > 异常返回 示例
    ```json5
    // TODO
    ```
            
    
## /document/query

- Request
    > 请求 示例
    ```json5
    {
        "pageNum": 1,
        "pageSize": 2,
        "keyword": "",
        "issueDateBegin": 1530230400000,     // 时间戳
        "issueDateEnd": 1535230400000        // 时间戳
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
                "total": 73,
                "pages": 25
            },
            "items": [
                {
                    "documentUUID": "92df265a-7ecc-4f52-b73c-0237d29f8a02",
                    "documentID": "555555",
                    "issueDate": 1532649600000,         // 时间戳
                    //...
                },
                {
                    "documentUUID": "907d1b33-1067-4bc8-8dea-12a506f43199",
                    "documentID": "234567",
                    "issueDate": 1532649600000,        // 时间戳
                    //...
                }
            ]
        },
        "ok": true
    }
    ```

