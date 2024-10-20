# Rent A Car Projesi
## Proje Amacı; </br>
Sayfaya kayıt olan müşteri login/logout işlemleri yapabilmeli, markaya göre araç sıralayıp seçebilmeli, seçilen tarih ve lokasyonlar doğrultusunda araçları görüntüleyebilmeli. Daha önce yaptığı kiralama işlemlerini görebilmeli.</br></br>
Admin login/logout işlemleri yapabilmeli ve kendisi için tasarlanan sayfaya yönlendirilmeli. Bütün araç ve markalar üzerinde silme/güncelleme/ekleme/görüntüleme işlemleri yapabilmeli, müşterilerin alışveriş detaylarını
görüntüleyebilmeli ve araç teslim alındıktan sonra onay vermelidir. </br>

## İndex Sayfası </br>
Jwt token rölünüz User ise index sayfasına yönlendirilirsiniz.</br>
İndex sayfasında araç alış/teslimat noktası ve alış/teslimat tarihi seçildikten sonra order sayfasına yönlendirilirsiniz.</br>
Burada araçları markasına göre sıralayıp, seçtiğiniz tarihler arası toplam ödenecek tutar ve araç bilgilerini bulabilirsiniz.</br>
Kiralama yapmadan önce araçların tamamına erişmek için index sayfasındayken navbar'da bulunan Cars'a tıklanarak bütün araçları görüntüleyebilirsiniz. </br>
Order sayfasında kirala butonuna tıklandığında bir popup açılır, kiralamak istediğiniz araç bilgileri popupda gözükür ve son bir onay alır. </br>
Ayrıca navbar üzerinden daha önce kiraladığınız araçların detaylarına erişebilirsiniz.
Kiraladığınız araç stoktan 1 adet düşer, kiralama sonrası stok 0'a inerse araç artık sistemde görüntülenmemektedir. </br></br>

## Admin Sayfası</br>
Jwt token rölünüz Admin ise admin sayfasına yönlendirilirsiniz. Burada tüm araçlar üzerinde güncelleme yapabilir (km,renk,görüntülenebilirlik,stok vb.), yeni araç ekleyebilir ve silebilirsiniz. </br>
Araç markası silinirken içerisinde 1 yada daha fazla araç varsa, marka silme işlemi başarısız olur. </br>
Bütün kullanıcıların kiralama geçmişini detaylı şekilde görüntüleyebilir ve Recieve Car butonuna tıklayarak aracın müşteriden alındığını teyit eder. </br>
Araç müşteriden alındıktan sonra stoğu +1 olacak şekilde düzenlenir. Eğer aracın stoğu halihazırda 0 ve görüntülenmesi pasif ise stok 1 olur ve araç görünürlüğü aktif hale geçer.

# Kullanılan Teknolojiler
Java - Backend </br>
SpringBoot </br>
Maven </br>
JwtToken </br>
OOP </br>
HTML </br>
CSS </br>
JavaScript </br>
PostgreSQL </br>
