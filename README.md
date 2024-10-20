# 🍔 Hamburger Yönetim Sistemi

Merhaba! Bu proje, Java Spring Boot ve PostgreSQL kullanarak geliştirdiğimiz bir Hamburger Yönetim Sistemi. Burada hamburger bilgilerini ekleyebilir, silebilir, güncelleyebilir ve listeleyebilirsiniz. Backend projesi tamamen Java ile yazıldı ve veritabanı olarak PostgreSQL kullandık.

## 📌 Projenin Özeti

Bu proje, hamburgerler ve onların malzemeleri arasında yönetim sağlayan bir sistemdir. Kullanıcılar, hamburger ekleme, silme, güncelleme ve listeleme işlemlerini gerçekleştirebilir. Projenin amacı, kullanıcıların hamburger bilgilerini kolayca yönetmelerine olanak tanımaktır.

## Neler Kullandık?
- **Java 17:** Ana dilimiz.
- **Spring Boot:** Backend kısmını hızlıca halletmek için.
- **PostgreSQL:** Veritabanı olarak seçtik, çünkü sağlam ve stabil.
- **pgAdmin:** PostgreSQL veritabanını yönetmek için kullandık.
- **Postman:** API’yi test etmek için, ayrıca sen de denemeler yapabilmen için Postman linkini aşağıda paylaşıyorum.
- **IntelliJ IDEA:** Kodları yazarken burayı tercih ettik.

## Nasıl Çalıştırırsınız?
Öncelikle Docker kurmakla uğraşmanıza gerek yok. Direkt olarak PostgreSQL'i kendi sisteminizde kurmanız yeterli. Şu adımları izleyerek projeyi hızlıca ayağa kaldırabilirsiniz:

1. PostgreSQL indir ve kur. Eğer PostgreSQL yüklü değilse, [buradan indir](https://www.postgresql.org/download/).
2. PostgreSQL kurduktan sonra, pgAdmin'i aç ve yeni bir veritabanı oluştur: `burgerManagement`.
3. Şimdi projeyi klonla:
   ```bash
   git clone [https://github.com/kullanici_adi/hamburger-yönetim-sistemi.git](https://github.com/Okyanusaydgn/BurgerProject.git)
   
##📡 API Endpoint'leri
Aşağıda birkaç endpoint paylaşıyorum. Bu endpoint'ler üzerinden hamburgerleri yönetebilirsiniz. Örneğin, hamburger ekleyebilir, mevcut hamburgerlerin bilgilerini güncelleyebilir, listeleyebilir veya silebilirsiniz.

HTTP Metodu	URL	Ne Yapar
GET	/api/burger	Tüm hamburgerleri listeler
POST	/api/burger	Yeni hamburger ekler
PUT	/api/burger/{id}	Hamburger bilgisini günceller
DELETE	/api/burger/{id}	Hamburgeri siler
## 📄 Örnek İstekler
# GET /api/burger
Bu istek, veritabanındaki tüm hamburgerleri listeleyecektir. Postman ile basit bir GET isteği yapabilirsiniz.

# POST /api/burger
Yeni bir hamburger eklemek için bu endpoint'i kullanabilirsiniz. Gövde (Body) kısmına aşağıdaki JSON verisini ekleyerek yeni bir hamburger ekleyebilirsiniz:
```
{
    "name": "Cheeseburger",
    "ingredients": ["beef patty", "cheese", "lettuce", "tomato"]
}
```

# PUT /api/burger/{id}
Mevcut bir hamburgerin bilgilerini güncellemek için bu endpoint'i kullanabilirsiniz. Örneğin, id değeri 1 olan bir hamburgerin bilgilerini güncellemek istiyorsanız, şu formatta bir PUT isteği yapmalısınız:
```
{
    "name": "Veggie Burger",
    "ingredients": ["vegetable patty", "lettuce", "tomato", "onion"]
}
```
## DELETE /api/burger/{id}
Bir hamburgeri silmek için kullanabilirsiniz. Örneğin, id değeri 2 olan bir hamburgeri silmek için şu şekilde bir DELETE isteği gönderebilirsiniz:

```
DELETE /api/burger/2
```
## 📖 Endpointler
# GET /api/burger
Açıklama: Tüm hamburgerlerin listesini getirir. Örnek Yanıt:
```
[
  {
    "id": 1,
    "name": "Cheeseburger",
    "ingredients": ["beef patty", "cheese", "lettuce", "tomato"]
  },
  {
    "id": 2,
    "name": "Veggie Burger",
    "ingredients": ["vegetable patty", "lettuce", "tomato", "onion"]
  }
]
```
# POST /api/burger
Açıklama: Yeni bir hamburger ekler. Örnek İstek Gövdesi:

```
{
  "name": "Chicken Burger",
  "ingredients": ["chicken patty", "mayo", "lettuce"]
}

```
# DELETE /api/burger/{id}
Açıklama: Belirtilen ID'ye sahip hamburgeri siler. Örnek:

```
DELETE /api/burger/2

```

## 🤝 Katkıda Bulunma
Bu projeye katkıda bulunmak istersen, lütfen önce bir sorun açarak veya benimle iletişime geçerek fikirlerini paylaş! Her türlü katkı için açığım. Ayrıca, pull request’ler de memnuniyetle karşılanır.

## 📧 İletişim
Soruların veya önerilerin için benimle iletişime geçebilirsin:

* E-posta: okyanusaydgn@gmail.com
* GitHub: Okyanusaydgn
