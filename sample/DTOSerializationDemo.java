package com.kingxunlian.document.threeleg;

import com.kingxunlian.document.common.JSON;
import com.kingxunlian.document.threeleg.dto.DespatchAdvice;
import com.kingxunlian.document.threeleg.dto.Document;

public class DTOSerializationDemo {

    public static void main(String[] args) {
        // When the response body document type is known to be DespatchAdvice
        DespatchAdvice da = JSON.parseObject(responseBody, DespatchAdvice.class);
        System.out.println("[DespatchAdvice]: " + da.getClass());
        System.out.println("\n[JSON.toJSONString()]: \n" + JSON.toJSONString(da));


        // When the response body document type is unknown
        Document document = JSON.parseObject(responseBody, Document.class);
        System.out.println("[class]: " + document.getClass());
        switch (document.getClass().getSimpleName()) {
            case "DespatchAdvice":
                DespatchAdvice da2 = (DespatchAdvice) document;
                System.out.println("\n[get DespatchAdvice.ID]: " + da2.ID);
                System.out.println("\n[JSON.toJSONString()]: \n" + JSON.toJSONString(document));
                break;
            default:
                break;
        }
    }


    public static final String responseBody = ("" +
            "{" +
            "  `DocumentType`: `DespatchAdvice`," +
            "  `ID`: `DA-X12`," +
            "  `IssueDate`: 1537259355768," +
            "  `Lines`: [{`ID`: 1}]" +
            "}").replace('`', '"');
}
