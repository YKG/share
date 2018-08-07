# 发货单两级索引添加字段


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