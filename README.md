# CraftRise Coin Level XP Plugin

![CraftRise Logo](https://www.speedrun.com/static/game/kdkzwpgd/cover.png?v=85a7caf)
![Spigot Logo](https://static.spigotmc.org/img/spigot-og.png)

CraftRise Coin Level XP Plugin, CraftRise sunucularında oyun oynarken oyuncuların seviye ve deneyim puanlarını takip etmek için kullanılan bir eklentidir. Bu eklenti ile ilgili önemli bilgilere ve yasal uyarılara aşağıda yer verilmiştir.

## Kullanım

Bu eklentiyi kullanmak için spigot ve papi gereklidir
## Yasal Uyarı

Bu eklenti, yalnızca kişisel ve eğlence amaçları için kullanılmalıdır. Bu eklenti ile elde edilen herhangi bir avantaj veya haksız kazanç cezalandırılabilir ve yasal işlemler başlatılabilir.

Eklentinin izinsiz kopyalanması, dağıtılması veya satılması yasaktır.


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

coinim
topcoin
expim
c
l
e
p
fipcoin
oduller
coinyolla 
toplevel
profil 

---

CraftRise Coin Level XP Plugin, Ozaii ve ekibi tarafından geliştirilmiştir ve tüm hakları saklıdır. İzinsiz kullanım veya dağıtım durumunda yasal işlemler başlatılacaktır.
