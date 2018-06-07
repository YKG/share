# Stock API

| URL                              | Method           | Request Body            | Response Body          | Function          |
| :-------------                   | :-------------   | :-------------          | :-------------         | :-------------    |
| /app/xl.stock/in/quality-inspect | POST             | {batchID, [QIR](#abbr)} | {retCode}           | 添加入库质量检查报告 |


## Abbreviation

| Entity              | 说明              | 备注                            | 
| :-------------      | :-------------    | :-------------                 | 
| batchID             | 批次号             |  | {statusCode}                | 
| QIR                 | 质检报告/质检结果   | Quality Inspect Report/Result  | 
| retCode             | 操作响应码         |  `0` 为成功，非 `0` 失败         | 
