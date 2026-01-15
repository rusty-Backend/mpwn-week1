# mpwn-week1
mobile-programmin-with-native-technologies Week 1

# Pari asiaa esittely videosta!
-En saanut ladattua YouTubeen, koska koitin tehdä koulusähköpostilla käyttäjän ja valita kanavanimeä, YouTube ilmoitti, että olin koittanu liian monta kertaa syöttää kanavanimen joka on jo käytössä -> Koita uudestaan 24h jälkeen. Video löytyy kuitenkin .mp4 tiedostona repositoriosta jonka voi ladata!

-Videossa ei ole ääntä. Jostain syystä ääni nauhoitus oli todella pätkivä ja säröilevä joten jätin videon ilman ääniraitaa. Voit kuvitella päässäsin hyvän monologin seuraamalla hiiren liikkeitä videota katsellessasi. Koitan korjata tämän seuraavaan viikkotehtävään.

# Ominaisuudet:
-Näyttää listan taskeja
-Käyttäjä voi merkata taskit joko suoritetuksi tai suorittamattomksi
-Suodattaa taskit joko tehtyjen tai päivämäärän perusteella
-Lisätä uuden taskin ja määrittää sille nimen
-Reset painikkeella pääsee alku tilaan

# Sovelluksen suorittaminen
-Lataa github repository koneelle
-Avaa Android studio ja projekti
-Anna Gradlen syncata
-Valitse joko laite tai emulaattori
-Paina ▶ suorita painiketta

# Projekti rakenne:
-Domain
  +MockTasks.kt
  +Task
  +TaskFunctions.kt
-ui
  +HomeScreen.kt
-MainActivity

# Task
-Meidän datamalli, sisältää luokan Task ja sen muuttujat ja niiden tyypit.

# MockTasks.kt
-Lista hard codattuja Taskejä

# TaskFunctions.kt
-Sisältää sovelluksessa kutsuttavat funktiot.

# HomeScreen.kt
-Sovelluksen näkymä joka kutsuu TaskFunctions.kt:n funktioita, UI-elementtien inputeilla. Käytännössä meidän sovellus pyörii tässä.

# MainActivity
-Käynnistää ja suorittää meidän HomeScreen.kt näkymän.


# Funktiot
-addTask(list, task) -> Lisää taskin listaan
-toggleDone(list, id) -> Vaihtaa taskin done arvon true/false
-filterByDone(list, done) -> Suodattaan task listasta vain ne task id joiden done arvo on true
-sortByDueDate(list) -> Suodattaa task listan dueDate arvon mukaan joka string eli aakosjärjestykseen eli kronologinen järjestys tässä tapauksessa.
-createTask(id, title) -> luo uuden Taskin vakioarvoilla titleä lukuunottamatta. Tämä uusi Task sitten lisätään addTask komenolla listaan.
