# CraftRise Coin Level XP Plugin

![CraftRise Logo](https://www.speedrun.com/static/game/kdkzwpgd/cover.png?v=85a7caf)
![Spigot Logo](https://static.spigotmc.org/img/spigot-og.png)

**CraftRise Coin Level XP Plugin**, CraftRise sunucularında oyun oynarken oyuncuların seviye ve deneyim puanlarını takip etmek için kullanılan bir eklentidir. Bu eklenti ile ilgili önemli bilgilere ve yasal uyarılara aşağıda yer verilmiştir.

## Kullanım

Bu eklentiyi kullanmak için spigot ve papi gereklidir. Plugins klasörüne atın, jar'ı çalıştırın, sunucuyu kapatın, sonra config.yml gelecek, onu düzenleyin ve MySQL bilgilerinizi girin.

## Yasal Uyarı

Bu eklenti, yalnızca kişisel ve eğlence amaçları için kullanılmalıdır. Bu eklenti ile elde edilen herhangi bir avantaj veya haksız kazanç cezalandırılabilir ve yasal işlemler başlatılabilir.

Eklentinin izinsiz kopyalanması, dağıtılması veya satılması yasaktır.

## PlaceHolders Kullanımı:

1. PlaceholderAPI'nin yüklü olduğundan emin olun.
2. Oyunculara özel metinleri göstermek için, bu sınıfın sağladığı placeholder'ları kullanabilirsiniz.

**PlaceHolders:**
- `%expercoins_xp%`: Oyuncunun XP'sini gösterir.
- `%expercoins_coin%`: Oyuncunun coin miktarını gösterir.
- `%expercoins_level%`: Oyuncunun seviyesini gösterir.
- `%expercoins_join_date%`: Oyuncunun katılma tarihini gösterir.
- `%expercoins_top_coin%`: En çok coine sahip oyuncuların listesini gösterir.
- `%expercoins_top_xp%`: En çok XP'e sahip oyuncuların listesini gösterir.
- `%expercoins_top_level%`: En yüksek seviyede oyuncuların listesini gösterir.

## Coin Api Kullanımı:

- `CoinManager.getPlayerCoins(playername)`: Coin sayısını getirir.
- `CoinManager.setPlayerCoins(playername, miktar)`: Coin'i belirtilen sayıya ayarlar.
- `CoinManager.resetPlayerCoins(playername)`: Coin sıfırlama.
- `CoinManager.addPlayerCoins(playername, miktar)`: Coin ekleme.
- `CoinManager.removePlayerCoins(playername, miktar)`: Coin eksiltme.
- `CoinManager.sendPlayerCoins(senderName, receiverName, coinsToSend)`: Coin yollama.
- `CoinManager.getTopPlayerCoins(miktar)`: En yüksek coin miktarına sahip oyuncuları getirir.

## Level Api Kullanımı:

- `LevelManager.getPlayerLevel(playername)`: Level sayısını getirir.
- `LevelManager.setPlayerLevel(playername, miktar)`: Level'i belirtilen sayıya ayarlar.
- `LevelManager.resetPlayerLevel(playername)`: Level sıfırlama.
- `LevelManager.addPlayerLevel(playername, miktar)`: Level ekleme.
- `LevelManager.removePlayerLevel(playername, miktar)`: Level eksiltme.
- `LevelManager.getTopPlayersLevel(miktar)`: En yüksek level miktarına sahip oyuncuları getirir.

## Exp Api Kullanımı:

- `ExpManager.getPlayerXp(playername)`: Level sayısını getirir.
- `ExpManager.setPlayerXp(playername, miktar)`: Level'i belirtilen sayıya ayarlar.
- `ExpManager.resetPlayerXp(playername)`: Level sıfırlama.
- `ExpManager.addPlayerXp(playername, miktar)`: Level ekleme.
- `ExpManager.removePlayerXp(playername, miktar)`: Level eksiltme.
- `ExpManager.getTopPlayerXP(miktar)`: En yüksek level miktarına sahip oyuncuları getirir.

## Exp Sistemi:

Exp sistemi 100xp de 1 level artacak şekilde düzenlenmiştir, istediğiniz gibi düzenleyebilirsiniz.

## Komutlar:

- **/coinim**: Coin miktarını gösterir.
- **/topcoin**: En yüksek coinleri gösterir.
- **/expim**: XP'yi gösterir.
- **/c**: Coin admin komutları.
- **/l**: Level admin komutları.
- **/e**: XP admin komutları.
- **/p**: Profil admin komutları.
- **/fipcoin**: Yazı tura.
- **/oduller**: Ödüller.
- **/coinyolla**: Coin yollama.
- **/toplevel**: En yüksek level.
- **/profil**: Profiliniz.

---

**CraftRise Coin Level XP Plugin**, Ozaii ve ekibi tarafından geliştirilmiştir ve tüm hakları saklıdır. İzinsiz kullanım veya dağıtım durumunda yasal işlemler başlatılacaktır.

### Oyun İçi Görseller:

![Spigot Logo](https://cdn.discordapp.com/attachments/1198742427251523666/1202951639783178250/image.png?ex=65cf5304&is=65bcde04&hm=1b358f64db83ec6f1f213f5abefcc91b1be8d73925a83b2635cff28b9d92d83c&)
![Placeholder1](https://cdn.discordapp.com/attachments/1198742427251523666/1202953112193867876/image.png?ex=65cf5463&is=65bcdf63&hm=56dd63f41d87af656e13afdd8f9c5a31eb7aa234932d0f4a36814517b4085cba&)
![Placeholder2](https://cdn.discordapp.com/attachments/1198742427251523666/1202953167302565908/image.png?ex=65cf5470&is=65bcdf70&hm=0b07134eadca926fb7a9d8827d304743dbb449e0d4d85c0050e544c21f22ba89&)
![Placeholders3](https://cdn.discordapp.com/attachments/1198742427251523666/1202953250865815572/image.png?ex=65cf5484&is=65bcdf84&hm=326c58655a7af97cd10bdb46c01ef8f6fdc939500c311acb614f20574b7f1974&)
![Placeholders3](https://cdn.discordapp.com/attachments/1198742427251523666/1202953329831845948/image.png?ex=65cf5497&is=65bcdf97&hm=94f4059b4817bfcef8ca609462926580e8d224639630c8091351a1df4ff1f250&)
![Placeholders3](https://cdn.discordapp.com/attachments/1198742427251523666/1202953423293644810/image.png?ex=65cf54ad&is=65bcdfad&hm=6c7a6d7d396bfb72ff644c109c9e965395cb3e2983f5efa9a8afc1378bd81ca6&)
