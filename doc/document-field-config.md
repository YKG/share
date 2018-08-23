# document-biz API - Document fields config


| URL                                                |  Function              |
| :-------------                                     | :-------------         |
| [/document/config/query](#documentconfigquery)     | 字段配置列表            |
| [/document/config/create](#documentconfigcreate)   | 增                     |
| [/document/config/delete](#documentconfigdelete)   | 删                     |
| [/document/config/update](#documentconfigupdate)   | 改                     |
| [/document/config/get](#documentconfigget)         | 查                     |

        
## /document/config/query

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
      "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a896",       // CompanyID
      "role": "Buyer",
      "documentType": "Order"
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": [
            {
                "configGroupUUID": "dfd02693-bb70-4e1c-8ad2-d23cc671cebf",
                "configUUID": "c9c2e4c1-4546-4352-a806-ccb02373c01e",
                "fieldName": "astr",
                "displayText": "显示字符",
                "description": "描述",
                "isRequired": true,
                "isVisible": true,
                "fieldType": "DocField",                                        // 单据字段
                "inputType": "SELECT",                                          // 下拉列表
                "regex": "^\\w+$",
                "invalidTip": "输入非法",
                "regexDescription": "字段名称regex"
            },
            {
                "configGroupUUID": "dfd02693-bb70-4e1c-8ad2-d23cc671cebf",
                "configUUID": "c3c5078f-f5bc-4296-8f08-fc0c2d95aca8",
                "fieldName": "aselect",
                "displayText": "显示字符",
                "description": "描述",
                "isRequired": true,
                "isVisible": true,
                "fieldType": "LineField",                                       // 行字段
                "inputType": "TEXT",                                            // 文本框
                "regex": "^\\w+$",
                "invalidTip": "输入非法",
                "regexDescription": "字段名称regex"
            }
        ],
        "ok": true
    }
    ```
    
    > 参数非法 示例
    ```json5
    // TODO
    ```
  

## /document/config/create

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
      "tenantID": "bb15da22-b890-4ceb-b830-d42c3676a896",
      "documentType": "Order",
      "role": "Buyer",
      "fieldConfig": {
          "configGroupUUID": null,
          "configUUID": null,
          "description": "描述",
          "displayText": "显示字符",
          "fieldName": "aselect",
          "fieldType": "DocField",
          "inputType": "TEXT",
          "invalidTip": "输入非法",
          "isRequired": true,
          "isVisible": true,
          "regex": "^\\w+$",
          "regexDescription": "字段名称regex"
       }
    }
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": "c3c5078f-f5bc-4296-8f08-fc0c2d95aca8",         // configUUID
        "ok": true
    }
    ```


## /document/config/delete

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```
    {
      "uuid": "94dc544f-793e-4069-a155-5195cd76d2a2"
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

## /document/config/update

- Method
    ```
    POST
    ```

- RequestBody 示例
    ```json5
    {
    	"uuid": "3e918b4d-e735-4456-80c5-1bddaba6a730",
    	"fieldConfig": 
    	{
    	  "configGroupUUID": null,
    	  "configUUID": "bb15da22-b890-4ceb-b830-d42c3676a896",
    	  "description": "描述1212",
    	  "displayText": "显示字符",
    	  "fieldName": "adate",
    	  "fieldType": "DocField",
    	  "inputType": "TEXT",
    	  "invalidTip": "输入非法",
    	  "isRequired": true,
    	  "isVisible": true,
    	  "regex": "^\\w+$",
    	  "regexDescription": "字段名称regex"
    	}
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

## /document/config/get

- Method
    ```
    GET
    ```

- QueryParam 示例
    ```
    uuid=94dc544f-793e-4069-a155-5195cd76d2a2
    ```

- Response

    > 正常返回 示例
    ```json5
    {
        "status": {
            "returnCode": "200"
        },
        "body": {
            "configGroupUUID": "dfd02693-bb70-4e1c-8ad2-d23cc671cebf",
            "configUUID": "94dc544f-793e-4069-a155-5195cd76d2a2",
            "fieldName": "adate3",
            "displayText": "显示字符",
            "description": "描述1212",
            "isRequired": true,
            "isVisible": true,
            "fieldType": "DocField",
            "inputType": "SELECT",                                          // 下拉列表
            "selectOptions": [{key:"11",val:"32" }, {key:"11",val:"32" }]   // 下拉列表键值对
            "regex": "^\\w+$",
            "invalidTip": "输入非法",
            "regexDescription": "字段名称regex"
        },
        "ok": true
    }
    ```
