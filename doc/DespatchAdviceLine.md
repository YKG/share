# 发货单 (DespatchAdvice)

## 两级索引添加字段

```json5
{
  "DocumentType": "DespatchAdvice",                     // 文档类型
  "IssueDate": 1530230400000,                           // 填报日期
  //...
  "Lines": [
    {
        "DocumentReference2": "Contract-42",            // 二级单据索引
        "LineReference2": "ContractLine-01",            // 二级单据行索引
    },
    //...
  ]
}
```


## 行数量更新 API

- URL
    ```
    /document/custom/yjyz/despatch-advice/update-quantity
    ```

- Method
    ```
    POST
    ```

- QueryBody 示例
    ```
    {
    	"documentUUID": "1eaf4a55-6488-4fb9-87cf-598fc0a16ed7",
    	"lineQuantity": [ 42 ]
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
    {
        "status": {
            "time": 1533627972468,
            "returnCode": "00102",
            "message": "request valid parameter error ",
            "description": "发货单数量更新行数不匹配",
            "serviceCode": "common-service"
        },
        "body": null,
        "ok": false
    }
    ```
