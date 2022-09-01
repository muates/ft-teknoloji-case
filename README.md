
-projeyi çalıştırabilmek için mysql ft_db şeması oluşturulmalıdır.

-application.properties içerisinde root ve rootuser gözden geçirilmeli

------------------------------------------------------------------------------------------------------------------------

-> create user

    POST localhost:8080/user/create
    
    request -> { 
    "firstName":"Murat",
    "lastName": "Ates",
    "mail": "mrtt.atss@gmail.com",
    "phone":"00000000000"}

-> create product

    POST localhost:8080/product/create
    
    request -> {
    "productName":"ekmek",
    "price":"5",
    "expirationDate":"2022-11-13"}

-> send comment 

    POST localhost:8080/comment/send

    request -> {
    "productComment":"nefis, herkese tavsiye ederim.",
    "product": {
        "id":"1"
    },
    "user": {
        "id":"1"
    }}

------------------------------------------------------------------------------------------------------------------------

-> Bir ürüne ait yorumları listeleyen bir metot yazınız.

    GET localhost:8080/comment/product/1

------------------------------------------------------------------------------------------------------------------------

-> Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız. 

    GET localhost:8080/comment/product/1/date?startDate=2022/05/01&endDate=2022/07/01

------------------------------------------------------------------------------------------------------------------------

-> Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.

    GET localhost:8080/comment/user/1

------------------------------------------------------------------------------------------------------------------------

-> Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız. 

    GET localhost:8080/comment/user/1/date?startDate=2022/05/01&endDate=2022/07/01

------------------------------------------------------------------------------------------------------------------------

-> Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız

    GET localhost:8080/products/expired

------------------------------------------------------------------------------------------------------------------------

-> Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)

    GET localhost:8080/products/unexpired