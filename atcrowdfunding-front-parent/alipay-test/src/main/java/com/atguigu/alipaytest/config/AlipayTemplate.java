package com.atguigu.alipaytest.config;

public class AlipayTemplate {

    //在支付宝创建的应用的id
    public static String app_id = "2016092200568607";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCSgX/nTQ0lD+S8ObaM5LGZ1hiz18GXnNpqPLhJCym4xOpn35FNPHrPkDGEoMKrZ5LJeA4cZulckD8AtpvBCpeyIkrj/i1WVmSg10hVX67MlVets4UecCHZv2hKAN0/iId76kozdqrd7Csp/YgXPquN9Np0NFotggTrmiBANk+vcpTF9SCGrDq/isOoCvClfbvVJjApfLLOel3yECe5K/SZ8puiWILVm1NxEXAqJ8z0ipPZVGrXsT6Bo0pEyCPcEL0SqaC9WT0zdWQzdUknCzZV9W2wKjEXBJG9hqxay5kPaKm9leBatSkDAaDxH/N5g36HRfY7BmklwRZsp17lHinxAgMBAAECggEAfnnfck35WBKFc90a9D0F+Xlzr+ZGEV3uzKIIsb46UXFlrzC5HoVkvEWOCiJCjHiIpvbGr8xED43TZgk/IwLC/JxQLM0kVJGWo6fWoSVOIP2YSLNe620APBvaq3BdkFiMJfSYBB+g2J7mkIR39SE8Nvu3j3QWmYzSNJbE2spINnwTzNBL1OPaB5h3hSjyI07KaUcOjhTBF0EZl83NlBDsxmQvy0NmuOIWAcIXXvGoIbwkA774J3LhwL+VS4W2FpQj4FlxvDlPu24GeNWN7oO66T3Jp9bweO120ObhuKwZQosDGkJq0975zVSJX5QtUWHMM/QDPO8Pk24n2AoPcACQcQKBgQDS6kqD+sK8dDBpkmxYopA1gJJATnur0RHFZJb5webOhnEZnePhB1hhhGvKFcrdY2hcYeQiUZkHMsnWItNUe9E9ccp4++m6KKG0iV/BQda7zx1zMTTZUMvSbO282Q31YnQu7Yz6BSk4f/U5Qbu61AK53Tv1ejSAgQhXt1Pwq8KD7QKBgQCx0pkqW4+53tY2o4iPqFGjKYI2yk5bAH5etmOvW51OZ4Slsq/aUJKBVG6fOpRVKkiXulHhrp5csZH0/C7kaj4Hy7TjgUKSWvwlv7i7jgN0dq/bhVJz82y+N9pENWvy5J0I8Kt67XH+6JDEGWjlV58auifMRSx5mRJNn5pM6qrFlQKBgFyZWm/JV1fv1xVyoLjlXlTvBsbO7kMH/jpgqFwtAk1n/x3VEShJ1kayIbTOjotWSopMvCFJG9tqM+0cyxWLatkELXWifAIsNpqRuYWah1FbZD2fu+kxLNtM0a+YyCUUvZeg2cUnIOraWupxbp9e13eMpvdmWMiWXfhM18CRWEwdAoGAUwT0l076EhgUQJwm1JML0jY94eCfpmLbnNJgRe1qysEPr+B1s2IslA7cOqC5we0kyRmmwsuoibQpZYwbRG7JmRAk2pZtgzDRSbpxv7a0rDoBLmbXMOU0Hraqw2+Bf3v2SMc79/9FWnIvrC4EyBYZZPwGOpsNAZRSdEUQX9qrceUCgYB99OOtFFt1ixzyTCyUj3Fuiw7BsPhdI3nuMSoNTPIDNpzRBp/KFXyv/FNJ2CjTAsX3OR3D6KmEYihqUfrYeb0P5zoybcQLMxbXxK+ec6F2o6U2iqFIq0MKwHUqsb9X3pj4qE0ZHbFgRtIHnL2/QGV5PFJdmIZIBKZcvB8fW6ztDA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyQQceVUChTJGtF/a8SXufhSxDTKporieTq9NO7yDZSpDlAX1zVPT/nf0KWAlxq1TYappWMIYtyrOABhJyn6flNP6vuSBiM5lYsepHvYrtRHqlFiJruEkiaCgEZBKL5aCfBHYj0oqgQn9MpNV/PEH4cBYAVaiI4+VX8CBUQfeEGjgN6OkpLULZ3X0JUkmSnVvCNJ1m3PD68IIlbOfEZXJUKCqmZhzprGR5VWswjxA+g87cMwvijL4gdkSy/daG62Bz5vApcmmMkuX1k1fMWP4ajZCASVw8HD+MSLRhd8We9F97gd8CW0TavzbdR+mTS5H4yEgO8F9HRAsbkhV9yu0yQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    public static String notify_url = "http://xb6cg22x28.52http.net/payAsync";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    public static String return_url = "http://xb6cg22x28.52http.net/orderList";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
