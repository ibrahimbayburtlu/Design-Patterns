# Design Pattern - Tasarım Kalıpları

# Behavioral Design Patterns

Merhaba, bu yazımda davranışsal tasarım kalıplarında sık kullanılan ve hem çalıştığım firmalarda hem de mülakatlarda sıkça karşıma çıkan noktaları inceleyeceğim.

**Peki, Behavioral Design Patterns nedir?**  
Design patterns (tasarım kalıpları), yazılım geliştirme sürecinde sık karşılaşılan problemler için geliştirilmiş, yeniden kullanılabilir nesne yönelimli çözümlerdir. Davranışsal tasarım kalıpları (Behavioral Design Patterns) ise temel olarak **nesnelerin birbirleriyle nasıl etkileşime geçtiği ve nasıl davrandığı** üzerine odaklanır.

### **Strategy Design Pattern**

Run-time sırasında nesnelerin davranışlarını belirlemek istediğimiz durumlarda kullanılan bir tasarım kalıbıdır.

![](https://miro.medium.com/v2/resize:fit:700/1*xLFR8BxmjlAjtMbxD58-4A.png)

Örneğin elimizde farklı ödeme stratejileri (örneğin: kredi kartı, havale, e-cüzdan vb.) olduğunu düşünelim. Uygulama çalışırken, yani run-time anında, farklı ödeme yöntemlerini dinamik olarak seçebilmemiz gerekir.

Bu sayede client’tan gelen isteğe göre uygun algoritmayı (ödeme yöntemini) seçip işlemi gerçekleştirebiliriz. Böylece sistem, yeni bir ödeme tipi eklense bile mevcut kodu değiştirmeden genişletilebilir hale gelir — bu da Open/Closed Principle’a uygun bir yapı sağlar.

Bunu kod üzerinden anlatmak istersek :

![](https://miro.medium.com/v2/resize:fit:700/1*YQTWjWiuS17C7OdtbW9NvA.png)

Yukarıda main metotta gördüğümüz gibi bir terminal açarız. Bu terminal üzerinden farklı ödeme stratejilerini kullanarak ödeme yapabiliriz.

![](https://miro.medium.com/v2/resize:fit:700/1*qNg40O7RP5Dj3cp6qfQhRQ.png)

Pos Terminal incelersek burada her strategy göre nesnenin davranışını farklılaştırdığımızı görürüz. Kredi olursa paymentStrategy = creditPayment olur. Geri kalan akış aynı kalırken sadece strategy set etmiş oluruz. Bunun sayesinde sürekli kodda değişiklik yapmak yerine sadece yeni ödeme türünü ekleriz ve PaymentStrategy implement etmesini sağlarız.

![](https://miro.medium.com/v2/resize:fit:700/1*U80p5crXshS_h5m-9jbXRA.png)

Credit Payment baktığımız gibi sadece PaymentStrategy implement etmiştir bunun sayede her bir ödeme tipi, kendi ödeme davranışını tanımlar ve sistemde bağımsız şekilde çalışır.

![](https://miro.medium.com/v2/resize:fit:700/1*9xl--nz2CrA_jHLMRq1NDQ.png)

DebitCardPayment sınıfı da benzer şekilde PaymentStrategy arayüzünü uygular. Yeni bir ödeme tipi eklendiğinde,sadece bu arayüzü implement etmek yeterlidir. Böylece mevcut kodda büyük değişiklik yapmadan sistemi genişletebiliriz. Bu yapı open/closed principle’a tam olarak uygundur.

> Strategy Pattern, “hangi sınıfın kullanılacağını run-time’da belirleme” ilkesine dayanır.Bu sayede if-else bloklarını azaltır, kod tekrarını önler ve sistemi genişletilebilir hale getirir.

### Observer Design Pattern :

Observer Design Pattern, bir nesnede (Subject) meydana gelen değişiklikleri, bu nesneyi gözlemleyen (Observer) diğer nesnelere otomatik olarak bildirmeyi sağlayan davranışsal bir tasarım kalıbıdır.

Bir nesnede değişiklik olduğunda, bu değişikliği kullanan diğer nesneleri manuel olarak güncellemek zorunda kalmadan otomatik olarak haberdar etmek istersek kullanırız. (Aynı process içinde)

Bir bankada müşterimiz var diyelim ve hesabına para göndersin. Bu gönderilen hesapta balance değişir o zaman bankada farklı kanallardan müşteriye bildirim göndermek ister.

Örnek olarak mobil uygulama bildirimi(hesabınıza para geldi — en sevilen bildirim :) ), SMS bildirimi, E-posta bildirimi, raporlama servisi.

Bu durumda Hesap aslında subject — gözlemlenen observers ise gözlemci, gözlemleyenler olur. Bunlarda SMS servisi, e-posta servisi, mobil uygulama servisi, raporlama servisi olur.

Hesap sistemi, bakiyede bir değişiklik olduğunda observer olanların hepsi kendine ait davranışı sergiler.

E-posta Servisi : Detaylı işlem özetini gönderir.  
Raporlama Servsisi : İstatistik tablosunu günceller.  
Mobil uygulama servisi : Hesabınıza para yattı notifi atar.

Observer Pattern temelde 4 kısımdan oluşur :

Observer Pattern dört temel bileşenden oluşur:

**Subject**(Publisher/Observable) -> observes kaydolduğu ve güncellemeleri aldığı nesnedir. (attach(), detach(), notify() metotlarına sahiptir)

**Observer** (Subscriber / Listener) -> Subject’teki değişikliklerini dinleyen arayüzdür. update() metodunu içerir.

**ConcreteSubject** -> Sıbject arayüzünü uygular. Durum değiştiğinde notify() çağırarak tüm gözlemcileri bilgilendirir.

**ConcreteObserver** -> Observer arayüzünü uygular. Sıbject’de gelen güncellemelerle kendi durumunu günceller.

Bu pattern’i kod üzerinden de incelememiz gerekirse

Subject’e yani gözlemlenen sınıf denk gelen sınıf aslında

![](https://miro.medium.com/v2/resize:fit:700/1*qVqlcZhS1Se3IIYKxpF2WA.png)

Bank Account sınıfına denk gelir çünkü bu sınıfta yaşanan balance deposit ve withdraw işlemleri üzerinden gözlemciler davranışlarını sergiler.

![](https://miro.medium.com/v2/resize:fit:700/1*GdgBpqJVbUiHwRyULVrOtA.png)

Observer denk gelen ise AccountObserver olur. Gözlemciler bunu implement ederek işlemlerini yapar.

![](https://miro.medium.com/v2/resize:fit:700/1*iKl4NARyYlqnU2AplXq3-w.png)

Mesela SmsService burada AccountObserver implement ederek işlemi update metodunu override eder.Farklı farklı kanallar ekleyebiliriz.

![](https://miro.medium.com/v2/resize:fit:700/1*31_qSJOkgAVRBs4HVhbtgw.png)

Temelde bir de bunların nasıl client tarafında kullanıldığına bakalım.

![](https://miro.medium.com/v2/resize:fit:700/1*hwAPKeXRhrofcr3VfrZMVg.png)

Burada email-sms-analytics servicelerini alıp account sınıfında observer olarak ekledik yani account hesabında bir değişiklik olduğunda bu sınıflar onu dinleyerek davranış gösterecekler.

![](https://miro.medium.com/v2/resize:fit:700/1*wsiLAWc3OUUFKIBX8pTu_A.png)


Ben sadece withdraw ve deposit yaptığımda gözlemci(observer) nesneler bunları dinler ve gerekli davranışı sergiler.

### Soru — 1 : Gerçek hayat kullanım senaryosu Nedir ?

Gerçek hayat örneği en temeli UI tarafında bir kısma bastığında UI’da diğer farklı yerlerinde bunu gözlemleyerek kendilerine ait metotları yapmasıdır.Bir butona tıklayınca ekranın başka kısımları güncellenir. Bu da Component event listener’a örnek verilebilir.

### Soru — 2 : Kafka ile ne farkı var o da bu işi yapmıyor mu ?

Bu iki kavram birbirine çok benzer mantıkla çalışır, ama farklı ölçeklerde ve farklı mimari seviyelerinde uygulanır.

Eğer olaylar aynı uygulama(monolit) içinde gerçekleşiyorsa observer Pattern kullanır. Eğer olaylar farklı servisler veya makienler arasında yayılacaksa **Kafka** kullanılır.

Observer temelde tek uygulama içinde(in-process), nesneler arasında doğrudan metot çağrısı, Senkron şekilde çalışır. Amaç,Nesneleri loosely coupled hale getirmek istenmektir. Hafif ve hızlı, tek JVM içinde performans gösterir.

Kafka ise event streaming olarak, farklı mikroservisler arasında (cross-process) çalışma alanında, Network üzerinden publish/subscribe bağlantı tipiyle, Asenkron broker sayesinde kullanılır. Log kayıtları tutulur. Mikroservis mimarileri, event-driven sistemlerde kullanılır.

### Template Method Design Pattern Nedir ?

Template Method Design Pattern, davranışsal tasarım kalıplarından biridir. Bu kalıp bir algoritmanın iskeletini üst sınıfta tanımlayıp, alt sınıfların sadece bazı adımlarını değiştirmesine izin verir.  
Ne yapılacağını üst sınıf belirler ancak nasıl yapılacağını alt sınıflar belirler.

![](https://miro.medium.com/v2/resize:fit:620/1*EUZdk_55M3nraeUlyuu_Fg.png)

Bir iş akışı temelde bellidir. Örneğin bir rapor oluşturmada tüm sürecin adımları hep aynı sırada gerçekleşir, ama bazı adımların detayları değişebilir. İşte Template Method burada devreye girer.

Elimde örnek bir rapor oluşturma yapısı olsun. Bu yapı temelde bellidir.

![](https://miro.medium.com/v2/resize:fit:700/1*6fMidnguyFkXGquw_DhQOQ.png)

Report Generator aslında bize genel bir template verir. Sen bir Rapor oluşturmak istiyorsan bunu implement edersin. Burada createReport ile sadece doküman türüne göre değişiklik yaparsın.

![](https://miro.medium.com/v2/resize:fit:700/1*lynGspa8L1thmWNMlQy0Vg.png)

Mesela PDF bir rapor oluşturmak istedim. createReport ile gerekli pdf kütüphaneleri ve logic alırım ve oluştururum. Genel akış üst sınıfa aittir.

![](https://miro.medium.com/v2/resize:fit:700/1*3iuDd-OG_PTcMaYGtpWILg.png)

Bu örnekte ise MicrosoftWorld bir rapor oluşturabilirim. Bunların kullanımına bakalım.

![](https://miro.medium.com/v2/resize:fit:700/1*pY6k1yGOHkVJcYfmhT554A.png)

Burada ReportGenerator implement eden sınıflardan PDFGenerator’u casting ettik ve pdfReport oluşturduk. Bunun sayesinde generateReport yaparak template metodu çağırdık ve alt sınıfta pdf bir doküman oluşturulmasını sağladık.

![](https://miro.medium.com/v2/resize:fit:662/1*GezN09FveZJFHIZTZ-DQRQ.png)

**Soru — 1: Abstract bir sınıf tanımlayıp implement etmek ile ne farkı var bu template metod’un ?**

Abstract sınıfta sadece bir genel yapı (interface) tanımlarsın. Alt sınıflar istediği şekilde uygular. Üst sınıfın istediği şekilde uygular. Üst sınıfın akışla hiçbir ilgisi yoktur. Yani akış tamamen alt sınıfta olur. Üst sınıf neyi hangi sırayla yapacağını bilmez.

Template’de ise üst sınıf akışı belirler. Alt sınıflar yalnızca değişen adımları doldurur. Yani ne yapılacağı sabittir nasıl yapılacağı alt sınıflara bırakılmıştır.

Abstract Class → Her rapor kendince bir yöntemle oluşturulsun. Excel isterse 5 adımda yapar, PDF isterse iki adımda yapar. Template ise tüm raporlar şu sırayla oluşturulacak : veri al -> işle -> rapor oluştur -> kaydet. Ama rapor oluştur kısmını siz kendinize göre doldurun demek oluyor.


# Structural Design Patternler


Structural design patternler, türkçe ismi ile yapısal tasarım desenleri aslında nesne ve sınıfların birbirleriyle nasıl ilişkilendirileceğini tanımlayan desenlerdir. Yapısal desenler, genellikle nesneler arasındaki ilişkileri basitleştirmek için kullanılmaktadır.

Creational design patternler temelde nesne oluşturma üzerine odaklanırken, structural bunların birbiriyle olan ilişkilerine odaklanır.

Birden çok structural design pattern bulunuyor ben sık kullanılan ve gerçek hayatta rastladıklarımı anlatacağım. Bunları incelemeye başlayalım.

### Adapter

Birbirleriyle uyumsuz iki sınıfın birlikte çalışmasını sağlamaktır. Bu konuyu biraz daha günlük hayata uygularsak elimizde 2 fiş olsun. Bunlarda birisi Amerikan Fişi diğeri de Türk fişi olsun. İkisi doğrudan uymaz ama bir adaptör kullanırsan amerikan fişini türk prizine takabilirsin.

![](https://miro.medium.com/v2/resize:fit:700/1*gfAqaoX3lMtrwSQm5SalyQ.jpeg)
Gerçek hayatta adaptör :)

Adapter pattern işte bunu kodda yapar: iki uyumsuz interface’i birbirine uyumlu hale getirir.

Bu konuda [refactoring guru](https://refactoring.guru/design-patterns/adapter) siteden bir örnek koymak istiyorum.

Hisse senedi piyasalarını takip etmeyi sağlayan bir uygulama geliştirdiğimizi düşünelim. Uygulama temelde piyasa verilerini farklı providerlardan XML formatında çekiyor ve daha sonra bu verileri client’da kullanıcıya gösteriyor. Burda temel düşüncemiz her provider’ın bize XML formatında döndüğümüzü düşünmemizdir.

![](https://miro.medium.com/v2/resize:fit:634/1*BFPvwABJcwR88LypABg81w.png)

Günün birinde üçüncü parti bir analiz kütüphanesi entegre ederek uygulamayı daha da geliştirmeye karar verdiniz diyelim. Yalnız bir sorun var, bu analiz kütüphanesi yalnızca JSON formatı ile çalışabiliyor.

Burada önümüzde 2 yol beliriyor.

a. kütüphaneyi xml formatına çevir.

b.json formatını xml formatına dönüştür.

Burada her kütüphaneyi xml formatına dönüştürürsem ileride kütüphane özelinde problemler yaşayabilirim sonuçta ben kütüphaneyi dönüştürüyorum ve maliyetli bir durum.

Bu noktada b. üzerinden ilerleriz. Bir adaptör yazabiliriz.Bu özel nesne bir nesnenin interface’ini değiştirerek diğer nesnenin kullanabileceği hale getirir. İlk resimdeki amerikan fişi — Türk fişi örneği gibi.

Adapter arka tarafta dönen kompleks dönüştürme işlemlerini gizlemek için nesnelerden birini tamamen sarar. Örneğin feet ve mil gibi emperyal işlem yapan bir kütüphaneyi bir adaptör ile sararak tüm veriyi kilometre ve metreye dönüştürebiliriz.

Adaptörler sadece veriyi farklı formatlara dönüştürmeye değil, aynı zamanda farklı arayüzlerin birlikte çalışmasını sağlar. Bir örnekle açıklamam gerekirse :

-   Adaptör mevcut nesnelerin birbiriyle uyumlu bir arayüzü alır.(Amerikan fişi gibi)
-   Mevcut nesne bu arayüzü kullanarak adaptörün metodalarını güvenli şekilde çağırabilir.
-   Bir istek geldiğinde adaptör isteği ikinci bir nesneye onun beklediği gibi formatda aktarır.(Amerikan fişi -> Türk fişi)

Duruma göre iki yönlü istekleri birbirine çevirebilecek bir adaptör bile oluşturulabilir.

![](https://miro.medium.com/v2/resize:fit:683/1*Ua0RE_tv9HFj5yu3xBUQwA.png)

Trade-App tekrar bakmamız gerekirse uyumsuz format sorunlarını çözmek için analitik kütüphanesini tüm sınıfları için bir XML — JSON dönüştürme adaptörü yazar ve kodumuz içerisinde bu adaptörü kullanabiliriz.Adaptör bir çağrı aldığında gelen XML verisinin JSON yapısına dönüştürür ve çağrıyı uygun metotlarda sarmaladığı analiz nesnesine aktarır.

> _Mevcut bir sınıfı (class) kullanmak istediğiniz fakat o sınıfın arayüzünün (interface) kodunuzun geri kalanı ile uyumlu olmadığı zamanlarda bir adaptör sınıfı kullanabilirsiniz._

Adaptör tasarım deseni, kodunuzla doğrudan uyumlu olmayan mevcut bir sınıf veya üçüncü parti kütüphane arasında bir nevi tercüman olarak hizmet eden bir ara katman oluşturmanızı sağlar.

Örnek bir kod olarak inceleme yapmamız gerekirse,

Elimizde örnek bir proje yapalım.

![](https://miro.medium.com/v2/resize:fit:700/1*BP_cbT_wsQasstdoB51CDA.png)

Elimizde bir main metodu olsun. Bu metotta gördüğümüz gibi mp3,mp4,vlc ve avi uzantılara sahip dosyalar ve bunları çalıştıracağım.

Öncelikle bir interface tanımlayalım çok temel bir işlem olan play işlemini yapsın.

![](https://miro.medium.com/v2/resize:fit:700/1*C3i7Fh0ZL7HOcok5BB9I-w.png)

Bu interface’i audioPlayer sınıfımızda kullanalım. Ancak sınıfımız sadece mp3 uygun bir yapısı olsun. Bunun dışındakiler için başka bir kütüphane kullandığımızı hayal edelim. Bu sınıf’ta AdvancedMediaPlayer olsun.

![](https://miro.medium.com/v2/resize:fit:700/1*XXHkKblu4SP-rCxhdxQ6tQ.png)

Bu sınıf görüldüğü gibi vlc ve mp4 videolarını çalıştırabilir. Bu noktada bana gelen file’ları mp3 değil ise vlc yada mp4 dönüştürme ihtiyacım ortaya çıktı. Bu noktada bir dönüştürücü adaptör yapmamız lazım.

![](https://miro.medium.com/v2/resize:fit:700/1*8BAiX2bVNSc-aoxDlHGQyA.png)

Bu adaptör yine MediaPlayer implement eder ve vlc ve mp4 dönüşüm sağlar. AudioPlayer’ı kodlarsak

![](https://miro.medium.com/v2/resize:fit:700/1*okfR4UZkZQckNc-e0RvCJg.png)

Eğer mp3 ise kendi çalışırırken mp4 ve vlc tarafında adaptör ile kütüphaneye dönüştürür.

Bu noktada ilk gelebilecek soru neden interface’i update etmedikte bu kadar adaptör yazmak durumunda kaldık. Bu aslında proje ile ilgili bir durum bazen projelerde bir interface’i güncellemek diğer implement edilen yerlerde problem oluştur yada kütüphane özelinde kod sana ait olmayabilir bu durumlarda adaptör yazmak durumunda kalırsın. Yada mevcut sisteme dokunmadan yeni bir şey entegre etmek isteyebilirsin.

REST → SOAP Dönüşümü servisleride temelde aynı çalışır. Eğer Rest ön yüze döneceksen ve arka planda SOAP varsa sen bir yerde dönüştürme yapman lazım bunun içinde Adapter yazarsın.

### Proxy

Proxy aslında orjinal nesneye erişimi kontrol ederek, istek orjinal nesneye ulaşmadan önce veya sonra bir şeyler gerçekletirmenize izin verir. Proxy başka bir nesne için bir yedek veya yer tutucu sağlamanıza olanak tanıyan structural bir tasarım desenidir.

Client temelde istekleri gerçek nesneye ileten proxy ile iletişim kurar. Proxy, ayrıca erişim kontrolü,lazy loading(sadece ihtiyaç anında oluşturma) ve önbelleğe alma gibi ek işlevler de sağlayabilir.

Mesela, web tarayıcılarında veya uygulamalarda, büyük görselleri yavaş yüklemek için proxy’ler kullanılır. Yer tutan bir proxy nesnesi, görseli temsil eder ve gerçek görseli yalnızca gerektiğinde yükleyerek performansı arttırır.

![](https://miro.medium.com/v2/resize:fit:510/1*oLtKvhNXeYIr61M_zKMQ4A.png)

Proxy pattern’i bir kod üzerinden anlatalım.

Öncelikle elimde bir interface olsun. BankService interface ile temel para çekme işlemini yapalım.

![](https://miro.medium.com/v2/resize:fit:700/1*Tf0h5vC9exE6AkKb9gchig.png)

Bu interface’i implement eden bir adette gerçek servis olsun.

![](https://miro.medium.com/v2/resize:fit:700/1*h1Bq0cAc1MF4UXdZ8_B2VQ.png)

Buraya kadar her şey çok normal elimde bir interface var ve servis bunu implement ediyor ama ben bu Real servisi kullanmadan önce bazı temel işlemler yapmak istiyorum aslında bir bekçi gibi öncesinde bazı şeyleri yapmasını istiyorum.

Bu servis’de BankServiceProxy olsun.

![](https://miro.medium.com/v2/resize:fit:700/1*HcCRdoINXuG2dDq9C-spog.png)

Bu şekilde eğer admin olmayan bir kullanıcı ise Real servisi kullanamasın. Bu sadece bir durum önbelleğe alma, filtreleme gibi bir çok şey yapabilirim.

![](https://miro.medium.com/v2/resize:fit:700/1*Xw2asKoD5Xu_0eBrBrevTw.png)

Bu şekilde bir işlem yapabilirim. Aslında proxy bir gerçek nesneye erişim yapmadan önce bazı işlemleri öncesinde yapmasına olanak sağlayan bir patterndir.

**Gerçek Hayat Kullanım :**

> Bir pos ödeme işleminde pos ödeme yapmadan önce bazı işlemlerin yapılmasını isteyebilirim. Bunlar rol kontrolü, loglama ve gereksiz external call engeleme gibi durumlar olabilir.  
> AOP’da aslında temelde Proxy ile çalışır.

### Decorator Design Pattern

Structural(Yapısal) designlardan biri olan decorator pattern aslında nesneleri wrapper nesneler içerisine yerleştirerek onlara yeni davranışlar kazandırmanızı sağlayan yapısal bir tasarım desenidir. Bu konuya girmeden önce ilk olarak Run-Time ve Compiler Time kavramlarını hatırlayalım.

> **Compile-Time**, programın çalıştırılmadan önce derleyici tarafından kontrol edildiği aşamadır. Bu aşamada sözdizimi (syntax) ve veri tipi gibi hatalar tespit edilir. **Run-Time** ise programın çalıştığı andır; yani kullanıcıyla etkileşime geçtiği, bellek işlemlerinin yürütüldüğü ve çalışma sırasında oluşabilecek hataların (örneğin sıfıra bölme, null pointer gibi) ortaya çıktığı aşamadır.

İlk önce sorunu inceleyelim :

Elimde bir sınıf var bu sınıf temelde 2–3 field alana ve constructor bir yapıya sahip olsun. Bu sınıfa ben bazı özellikler eklemek istiyorum. Mesela bir notif sınıfı ise send() ile E-mail gönderme dışında SMS,WhatsApp Mesajı.. bir çok mesaj göndermek istiyorum. Ne yaparım ?

![](https://miro.medium.com/v2/resize:fit:540/1*juJV1tXDhPH8ZcMOgXC7zQ.png)

Hepimizin aklına geldiği gibi sınıfın içine tüm göndermek istediğim türler extend ederim. Sonuç olarak elimde her tür için sınıflar olur. Bu peki best-practices midir hayır. Ben belki farklı bir mesaj türü daha eklemek istiyorum her sınıfta değişiklik yapmak mı isteyeceğim.

Bir nesnenin davranış şeklini değiştirmeniz gerektiğinde ilk akla gelen o sınııf genişletmek(extend) oluyor. Fakat bunu yaparken bu miras yönteminin ciddi olabilecek bazı sonuçları ortaya çıkar.

-   Inheritance statiktir. Mevcut bir objenin davranışını çalışma anında değiştiremezsiniz. Ancak bir sınıfta yeni bir nesne oluşturarak mevcut nesneyi tamamen değiştirebilirsiniz.
-   Alt sınıfların sadece bir ana sınıfı olabilir. Bir çok programlama dili bir sınıfın aynı anda birden fazla sınıftan miras almasına (inheritance) izin vermez.

Bu sorunu aşmanın bir yolu inheritance yerine Aggregation veya Composition kullanmaktır. Her iki alternatifte benzer şekilde çalışır, bir nesnein bir başka nesneye referans içerir ve işin bir kısmını o nesneye yaptırır, inhertitance’da ise nesnenin kendisi ana sınıftan miras aldığı yöntemleri kullanarak işi kendisi yapar.

Decorator tasarım kalıbının bir diğer adı da Wrapper, yani sarayıcıdır ve aslında bu isim deseninin ana fikrini yansıtır. Wrapper bir nesne bir hedef nesneyle ilişkilendirir. Wrapper, hedefle aynı metod setine sahiptir ve aldığı tüm istekleri ona delege eder. Fakat wrapper bu isteği alıcıya göndermeden önce ya da sonra başka şeyler yaparak sonucu kısmen ya da tamamen değiştirebilirir.

Hadi kod ile bu konuyu biraz inceleyelim : )

Elimde interface bir Notifier kodu olsun.

![](https://miro.medium.com/v2/resize:fit:700/1*c3IonMWE4ZOFrIDGJUOIxQ.png)

Sonra bu interface eden bir E-Mail sınıfı olsun.

![](https://miro.medium.com/v2/resize:fit:700/1*Tf1HAqrzioMfbGBzP2rWdw.png)

Buraya kadar her şey normal. E-mail gönderen elimde bir servis var artık bu e-mail servisine başka kanallardan da çalışan bir sınıf yazalım.

![](https://miro.medium.com/v2/resize:fit:700/1*p20zc3Gmb54u8RREqNMgkQ.png)

Decorator olan bu sınıf aslında temelde notifier nesnesini alıp wrapper ediyor. Farklı farklı kanallar’da (slack-sms) ile bu sınıfı implement ederek yeni özellikler ekleyebilirim.

![](https://miro.medium.com/v2/resize:fit:700/1*841QzPKWcZrWC1xLxxjXXQ.png)

![](https://miro.medium.com/v2/resize:fit:700/1*EYIUHxmK0kb5kZmit9ih5Q.png)

Bu şekilde hem Slack hemde SMS tarafında mesaj gönderme fırsatım oldu.

![](https://miro.medium.com/v2/resize:fit:700/1*_pV32NC57IqturGHBLpUew.png)

Sırasıyla e-mail , SMS, Slack mesajları iletilmiş oldu.

### Facade Design Pattern

Facade design benim için özel anlamı olan bir pattern çünkü ilk staj yaptığım firmada projede aktif kullanılıyordu bende anlamıyordum :) Bu noktada zamanında çok araştırma yapmış biri olarak Facade design pattern, temelde çok fazla özellik olan bir sistemi sanki düşük bir level’e dönüştürür. Örnek olarak, bir otel resepsiyonu düşünelim. Misafir olarak sen otel personelini, kat hizmetlerini, restoranı veya teknik servisi tek tek aramazsın resepsiyona söylersin, o da gerekli birimlerle iletişime geçer.Resepsioyon burada Facade görevi görür.

![](https://miro.medium.com/v2/resize:fit:700/1*SAmkOGLZV_HDr4c1WZBeXw.jpeg)

Yada bir film izleyeceksin diyelim Netflix girdim. Netflix’de filmi seçip enter basarım dimi sonrasında film başlar. Peki arka planda sadece film mi seçiliyor ayarlamalar olmuyor mu? Tabiki de oluyor ama biz daha temel bir arayüz üzerinden işlem yapıyoruz ve sistemin karmaşıklığını arka planda bırakırız.

Kod üzerinden inceleyelim.

![](https://miro.medium.com/v2/resize:fit:698/1*hvYdqJVixDskAEif8PLuPQ.png)

![](https://miro.medium.com/v2/resize:fit:700/1*Xr_GbEQw1s25JYjF_qfV7w.png)

![](https://miro.medium.com/v2/resize:fit:628/1*J_EFdYDAHkW4gWCNpVOZaw.png)

Elimde 3 adet sistem olsun hepsininde kendine ait özelliklere sahip olduğunu hayal edelim. Bu sistemlerin nasıl çalıştığını kullanıcı bilmek zorunda mı ? Değil çünkü kullanıcı video izlemek istiyor.

![](https://miro.medium.com/v2/resize:fit:700/1*V7MOPyVbUYMDTs536nCKjA.png)

Temel bir sınıf üzerinden client sınıfa erişir ve sadece ihtiyacı olan filmi izle yada durdur basarak işini halleder. Biz aslında Facade sayesinde sistemin karmaşıklığını gizlemiş oluyoruz.

![](https://miro.medium.com/v2/resize:fit:623/1*PpIOEK_98TpS3EXszEg1Og.png)

Demo’da görüldüğü gibi çok temel bir işlem yapıyor sadece filmi izliyor yada kapatıyor bu kadar :)

Structural Design pattern konusunda benim öğrendiklerim ve sık kullanılanlar bunlar.Bu yazıyı hazırlarken refactoring.guru hesabını aktif kullandım. Bu kadar güzel bir kaynak ürettiği için kendisine teşekkürler.



# Behavioral Design Patterns

**Peki, Behavioral Design Patterns nedir?**  
Design patterns (tasarım kalıpları), yazılım geliştirme sürecinde sık karşılaşılan problemler için geliştirilmiş, yeniden kullanılabilir nesne yönelimli çözümlerdir. Davranışsal tasarım kalıpları (Behavioral Design Patterns) ise temel olarak **nesnelerin birbirleriyle nasıl etkileşime geçtiği ve nasıl davrandığı** üzerine odaklanır.

### **Strategy Design Pattern**

Run-time sırasında nesnelerin davranışlarını belirlemek istediğimiz durumlarda kullanılan bir tasarım kalıbıdır.

![](https://miro.medium.com/v2/resize:fit:700/1*xLFR8BxmjlAjtMbxD58-4A.png)

Örneğin elimizde farklı ödeme stratejileri (örneğin: kredi kartı, havale, e-cüzdan vb.) olduğunu düşünelim. Uygulama çalışırken, yani run-time anında, farklı ödeme yöntemlerini dinamik olarak seçebilmemiz gerekir.

Bu sayede client’tan gelen isteğe göre uygun algoritmayı (ödeme yöntemini) seçip işlemi gerçekleştirebiliriz. Böylece sistem, yeni bir ödeme tipi eklense bile mevcut kodu değiştirmeden genişletilebilir hale gelir — bu da Open/Closed Principle’a uygun bir yapı sağlar.

Bunu kod üzerinden anlatmak istersek :

![](https://miro.medium.com/v2/resize:fit:700/1*YQTWjWiuS17C7OdtbW9NvA.png)

Yukarıda main metotta gördüğümüz gibi bir terminal açarız. Bu terminal üzerinden farklı ödeme stratejilerini kullanarak ödeme yapabiliriz.

![](https://miro.medium.com/v2/resize:fit:700/1*qNg40O7RP5Dj3cp6qfQhRQ.png)

Pos Terminal incelersek burada her strategy göre nesnenin davranışını farklılaştırdığımızı görürüz. Kredi olursa paymentStrategy = creditPayment olur. Geri kalan akış aynı kalırken sadece strategy set etmiş oluruz. Bunun sayesinde sürekli kodda değişiklik yapmak yerine sadece yeni ödeme türünü ekleriz ve PaymentStrategy implement etmesini sağlarız.

![](https://miro.medium.com/v2/resize:fit:700/1*U80p5crXshS_h5m-9jbXRA.png)

Credit Payment baktığımız gibi sadece PaymentStrategy implement etmiştir bunun sayede her bir ödeme tipi, kendi ödeme davranışını tanımlar ve sistemde bağımsız şekilde çalışır.

![](https://miro.medium.com/v2/resize:fit:700/1*9xl--nz2CrA_jHLMRq1NDQ.png)

DebitCardPayment sınıfı da benzer şekilde PaymentStrategy arayüzünü uygular. Yeni bir ödeme tipi eklendiğinde,sadece bu arayüzü implement etmek yeterlidir. Böylece mevcut kodda büyük değişiklik yapmadan sistemi genişletebiliriz. Bu yapı open/closed principle’a tam olarak uygundur.

> Strategy Pattern, “hangi sınıfın kullanılacağını run-time’da belirleme” ilkesine dayanır.Bu sayede if-else bloklarını azaltır, kod tekrarını önler ve sistemi genişletilebilir hale getirir.

### Observer Design Pattern :

Observer Design Pattern, bir nesnede (Subject) meydana gelen değişiklikleri, bu nesneyi gözlemleyen (Observer) diğer nesnelere otomatik olarak bildirmeyi sağlayan davranışsal bir tasarım kalıbıdır.

Bir nesnede değişiklik olduğunda, bu değişikliği kullanan diğer nesneleri manuel olarak güncellemek zorunda kalmadan otomatik olarak haberdar etmek istersek kullanırız. (Aynı process içinde)

Bir bankada müşterimiz var diyelim ve hesabına para göndersin. Bu gönderilen hesapta balance değişir o zaman bankada farklı kanallardan müşteriye bildirim göndermek ister.

Örnek olarak mobil uygulama bildirimi(hesabınıza para geldi — en sevilen bildirim :) ), SMS bildirimi, E-posta bildirimi, raporlama servisi.

Bu durumda Hesap aslında subject — gözlemlenen observers ise gözlemci, gözlemleyenler olur. Bunlarda SMS servisi, e-posta servisi, mobil uygulama servisi, raporlama servisi olur.

Hesap sistemi, bakiyede bir değişiklik olduğunda observer olanların hepsi kendine ait davranışı sergiler.

E-posta Servisi : Detaylı işlem özetini gönderir.  
Raporlama Servsisi : İstatistik tablosunu günceller.  
Mobil uygulama servisi : Hesabınıza para yattı notifi atar.

Observer Pattern temelde 4 kısımdan oluşur :

Observer Pattern dört temel bileşenden oluşur:

**Subject**(Publisher/Observable) -> observes kaydolduğu ve güncellemeleri aldığı nesnedir. (attach(), detach(), notify() metotlarına sahiptir)

**Observer** (Subscriber / Listener) -> Subject’teki değişikliklerini dinleyen arayüzdür. update() metodunu içerir.

**ConcreteSubject** -> Sıbject arayüzünü uygular. Durum değiştiğinde notify() çağırarak tüm gözlemcileri bilgilendirir.

**ConcreteObserver** -> Observer arayüzünü uygular. Sıbject’de gelen güncellemelerle kendi durumunu günceller.

Bu pattern’i kod üzerinden de incelememiz gerekirse

Subject’e yani gözlemlenen sınıf denk gelen sınıf aslında

![](https://miro.medium.com/v2/resize:fit:700/1*qVqlcZhS1Se3IIYKxpF2WA.png)

Bank Account sınıfına denk gelir çünkü bu sınıfta yaşanan balance deposit ve withdraw işlemleri üzerinden gözlemciler davranışlarını sergiler.

![](https://miro.medium.com/v2/resize:fit:700/1*GdgBpqJVbUiHwRyULVrOtA.png)

Observer denk gelen ise AccountObserver olur. Gözlemciler bunu implement ederek işlemlerini yapar.

![](https://miro.medium.com/v2/resize:fit:700/1*iKl4NARyYlqnU2AplXq3-w.png)

Mesela SmsService burada AccountObserver implement ederek işlemi update metodunu override eder.Farklı farklı kanallar ekleyebiliriz.

![](https://miro.medium.com/v2/resize:fit:700/1*31_qSJOkgAVRBs4HVhbtgw.png)
Temelde bir de bunların nasıl client tarafında kullanıldığına bakalım.

![](https://miro.medium.com/v2/resize:fit:700/1*hwAPKeXRhrofcr3VfrZMVg.png)

Burada email-sms-analytics servicelerini alıp account sınıfında observer olarak ekledik yani account hesabında bir değişiklik olduğunda bu sınıflar onu dinleyerek davranış gösterecekler.

![](https://miro.medium.com/v2/resize:fit:700/1*wsiLAWc3OUUFKIBX8pTu_A.png)

Ben sadece withdraw ve deposit yaptığımda gözlemci(observer) nesneler bunları dinler ve gerekli davranışı sergiler.

### Soru — 1 : Gerçek hayat kullanım senaryosu Nedir ?

Gerçek hayat örneği en temeli UI tarafında bir kısma bastığında UI’da diğer farklı yerlerinde bunu gözlemleyerek kendilerine ait metotları yapmasıdır.Bir butona tıklayınca ekranın başka kısımları güncellenir. Bu da Component event listener’a örnek verilebilir.

### Soru — 2 : Kafka ile ne farkı var o da bu işi yapmıyor mu ?

Bu iki kavram birbirine çok benzer mantıkla çalışır, ama farklı ölçeklerde ve farklı mimari seviyelerinde uygulanır.

Eğer olaylar aynı uygulama(monolit) içinde gerçekleşiyorsa observer Pattern kullanır. Eğer olaylar farklı servisler veya makienler arasında yayılacaksa **Kafka** kullanılır.

Observer temelde tek uygulama içinde(in-process), nesneler arasında doğrudan metot çağrısı, Senkron şekilde çalışır. Amaç,Nesneleri loosely coupled hale getirmek istenmektir. Hafif ve hızlı, tek JVM içinde performans gösterir.

Kafka ise event streaming olarak, farklı mikroservisler arasında (cross-process) çalışma alanında, Network üzerinden publish/subscribe bağlantı tipiyle, Asenkron broker sayesinde kullanılır. Log kayıtları tutulur. Mikroservis mimarileri, event-driven sistemlerde kullanılır.

### Template Method Design Pattern Nedir ?

Template Method Design Pattern, davranışsal tasarım kalıplarından biridir. Bu kalıp bir algoritmanın iskeletini üst sınıfta tanımlayıp, alt sınıfların sadece bazı adımlarını değiştirmesine izin verir.  
Ne yapılacağını üst sınıf belirler ancak nasıl yapılacağını alt sınıflar belirler.

![](https://miro.medium.com/v2/resize:fit:620/1*EUZdk_55M3nraeUlyuu_Fg.png)

Bir iş akışı temelde bellidir. Örneğin bir rapor oluşturmada tüm sürecin adımları hep aynı sırada gerçekleşir, ama bazı adımların detayları değişebilir. İşte Template Method burada devreye girer.

Elimde örnek bir rapor oluşturma yapısı olsun. Bu yapı temelde bellidir.

![](https://miro.medium.com/v2/resize:fit:700/1*6fMidnguyFkXGquw_DhQOQ.png)

Report Generator aslında bize genel bir template verir. Sen bir Rapor oluşturmak istiyorsan bunu implement edersin. Burada createReport ile sadece doküman türüne göre değişiklik yaparsın.

![](https://miro.medium.com/v2/resize:fit:700/1*lynGspa8L1thmWNMlQy0Vg.png)

Mesela PDF bir rapor oluşturmak istedim. createReport ile gerekli pdf kütüphaneleri ve logic alırım ve oluştururum. Genel akış üst sınıfa aittir.

![](https://miro.medium.com/v2/resize:fit:700/1*3iuDd-OG_PTcMaYGtpWILg.png)

Bu örnekte ise MicrosoftWorld bir rapor oluşturabilirim. Bunların kullanımına bakalım.

![](https://miro.medium.com/v2/resize:fit:700/1*pY6k1yGOHkVJcYfmhT554A.png)

Burada ReportGenerator implement eden sınıflardan PDFGenerator’u casting ettik ve pdfReport oluşturduk. Bunun sayesinde generateReport yaparak template metodu çağırdık ve alt sınıfta pdf bir doküman oluşturulmasını sağladık.

![](https://miro.medium.com/v2/resize:fit:662/1*GezN09FveZJFHIZTZ-DQRQ.png)

**Soru — 1: Abstract bir sınıf tanımlayıp implement etmek ile ne farkı var bu template metod’un ?**

Abstract sınıfta sadece bir genel yapı (interface) tanımlarsın. Alt sınıflar istediği şekilde uygular. Üst sınıfın istediği şekilde uygular. Üst sınıfın akışla hiçbir ilgisi yoktur. Yani akış tamamen alt sınıfta olur. Üst sınıf neyi hangi sırayla yapacağını bilmez.

Template’de ise üst sınıf akışı belirler. Alt sınıflar yalnızca değişen adımları doldurur. Yani ne yapılacağı sabittir nasıl yapılacağı alt sınıflara bırakılmıştır.

Abstract Class → Her rapor kendince bir yöntemle oluşturulsun. Excel isterse 5 adımda yapar, PDF isterse iki adımda yapar. Template ise tüm raporlar şu sırayla oluşturulacak : veri al -> işle -> rapor oluştur -> kaydet. Ama rapor oluştur kısmını siz kendinize göre doldurun demek oluyor.


### Kaynaklar :

-   [https://refactoring.guru/](https://refactoring.guru/)
-   [https://www.evrenbal.com/template-method-tasarim-deseni-nedir/](https://www.evrenbal.com/template-method-tasarim-deseni-nedir/)
-   ChatGPT














