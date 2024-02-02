# CraftRise Coin Level XP Plugin

![CraftRise Logo](https://www.speedrun.com/static/game/kdkzwpgd/cover.png?v=85a7caf)
![Spigot Logo](https://static.spigotmc.org/img/spigot-og.png)

CraftRise Coin Level XP Plugin, CraftRise sunucularında oyun oynarken oyuncuların seviye ve deneyim puanlarını takip etmek için kullanılan bir eklentidir. Bu eklenti ile ilgili önemli bilgilere ve yasal uyarılara aşağıda yer verilmiştir.

## Kullanım

Bu eklentiyi kullanmak için spigot ve papi gereklidir
Plugins klasörüne atın jarı calıstırın sunucuyu sonra kapatın sonra config.yml gelicek onu duzenleyin mysql bilgilerinizi girin ve hazir.

## Yasal Uyarı

Bu eklenti, yalnızca kişisel ve eğlence amaçları için kullanılmalıdır. Bu eklenti ile elde edilen herhangi bir avantaj veya haksız kazanç cezalandırılabilir ve yasal işlemler başlatılabilir.

Eklentinin izinsiz kopyalanması, dağıtılması veya satılması yasaktır.

## PlaceHolders Kullanımı:



1. Öncelikle PlaceholderAPI'nin yüklü olduğundan emin olun.
2. Oyunculara özel metinleri göstermek için, bu sınıfın sağladığı placeholder'ları kullanabilirsiniz.

Örneğin, oyunculara `/papi parse <oyuncu> %expercoins_xp%` komutunu kullanarak "Oyuncunun XP'si: xxx" gibi bir mesaj gösterebilirsiniz.

#### PlaceHolders:

- `%expercoins_xp%`: Oyuncunun XP'sini gösterir.
- `%expercoins_coin%`: Oyuncunun coin miktarını gösterir.
- `%expercoins_level%`: Oyuncunun seviyesini gösterir.
- `%expercoins_join_date%`: Oyuncunun katılma tarihini gösterir.
- `%expercoins_top_coin%`: En çok coine sahip oyuncuların listesini gösterir.
- `%expercoins_top_xp%`: En çok XP'e sahip oyuncuların listesini gösterir.
- `%expercoins_top_level%`: En yüksek seviyede oyuncuların listesini gösterir.


## Coin Api Kullanımı:

CoinManager.getPlayerCoins(playername) => coin sayısını getirir
CoinManager.setPlayerCoins(playername,miktar) => coin i belirtilen sayıya ayarlar
CoinManager.resetPlayerCoins(playername) => coin sıfırlama
CoinManager.addPlayerCoins(playername,miktar) => coin ekleme
CoinManager.removePlayerCoins(playername,miktar) => coin eksiltme
CoinManager.sendPlayerCoins(String senderName, String receiverName, int coinsToSend) => coin yollama
CoinManager.getTopPlayerCoins(miktar) => en yüksek coin miktarına sahip oyuncuları getirir


## Level Api Kullanımı:

LevelManager.getPlayerLevel(playername) => level sayısını getirir
LevelManager.setPlayerLevel(playername,miktar) => level i belirtilen sayıya ayarlar
LevelManager.resetPlayerLevel(playername) => level sıfırlama
LevelManager.addPlayerLevel(playername,miktar) => level ekleme
LevelManager.removePlayerLevel(playername,miktar) => level eksiltme
LevelManager.getTopPlayersLevel(miktar) => en yüksek level miktarına sahip oyuncuları getirir


## Exp Api Kullanımı:

ExpManager.getPlayerXp(playername) => level sayısını getirir
ExpManager.setPlayerXp(playername,miktar) => level i belirtilen sayıya ayarlar
ExpManager.resetPlayerXp(playername) => level sıfırlama
ExpManager.addPlayerXp(playername,miktar) => level ekleme
ExpManager.removePlayerXp(playername,miktar) => level eksiltme
ExpManager.getTopPlayerXP(miktar) => en yüksek level miktarına sahip oyuncuları getirir


## Exp Sistemi:

Exp sistemi 100xp de 1 level artıcak şekilde düzenlenmiştir istediğiniz gibi editleyebilirsiniz bu kısımı


## Komutlar:

#### /coinim
coin miktarıni gosterir
#### /topcoin
en yuksek coinleri gosterir
#### /expim
xp nizi gosterir
#### /c
coin admin komutlari
#### /l
level admin komutlari 
#### /e
xp admin komutlari
#### /p
profil admin komutlari
#### /fipcoin
yazi tura
#### /oduller
oduller
#### /coinyolla 
coin yollama
#### /toplevel
en yuksek leveller
#### /profil 
profiliniz

---

CraftRise Coin Level XP Plugin, Ozaii ve ekibi tarafından geliştirilmiştir ve tüm hakları saklıdır. İzinsiz kullanım veya dağıtım durumunda yasal işlemler başlatılacaktır.
 
### Oyun ici gorseller :
![Spigot Logo](https://cdn.discordapp.com/attachments/1198742427251523666/1202951639783178250/image.png?ex=65cf5304&is=65bcde04&hm=1b358f64db83ec6f1f213f5abefcc91b1be8d73925a83b2635cff28b9d92d83c&)

![Placeholder1](https://cdn.discordapp.com/attachments/1198742427251523666/1202953112193867876/image.png?ex=65cf5463&is=65bcdf63&hm=56dd63f41d87af656e13afdd8f9c5a31eb7aa234932d0f4a36814517b4085cba&)

![Placeholder2](https://cdn.discordapp.com/attachments/1198742427251523666/1202953167302565908/image.png?ex=65cf5470&is=65bcdf70&hm=0b07134eadca926fb7a9d8827d304743dbb449e0d4d85c0050e544c21f22ba89&)

![Placeholders3](https://cdn.discordapp.com/attachments/1198742427251523666/1202953250865815572/image.png?ex=65cf5484&is=65bcdf84&hm=326c58655a7af97cd10bdb46c01ef8f6fdc939500c311acb614f20574b7f1974&)

![Placeholders3]()

![Placeholders3]()