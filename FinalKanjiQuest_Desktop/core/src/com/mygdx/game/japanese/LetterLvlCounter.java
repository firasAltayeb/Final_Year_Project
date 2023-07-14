package com.mygdx.game.japanese;


import java.util.Hashtable;

/**
 * Created by firasAltayeb on 07/04/2017.
 */

public class LetterLvlCounter {

    private int
         hiraganaALvl,     hiraganaKaLvl,
         hiraganaILvl,     hiraganaKiLvl,
         hiraganaULvl,     hiraganaKuLvl,
         hiraganaELvl,     hiraganaKeLvl,
         hiraganaOLvl,     hiraganaKoLvl,

         hiraganaSaLvl,     hiraganaTaLvl,
         hiraganaShiLvl,    hiraganaChiLvl,
         hiraganaSuLvl,     hiraganaTsuLvl,
         hiraganaSeLvl,     hiraganaTeLvl,
         hiraganaSoLvl,     hiraganaToLvl,

         hiraganaNaLvl,     hiraganaHaLvl,
         hiraganaNiLvl,     hiraganaHiLvl,
         hiraganaNuLvl,     hiraganaHuLvl,
         hiraganaNeLvl,     hiraganaHeLvl,
         hiraganaNoLvl,     hiraganaHoLvl,

         hiraganaMaLvl,     hiraganaRaLvl,
         hiraganaMiLvl,     hiraganaRiLvl,
         hiraganaMuLvl,     hiraganaRuLvl,
         hiraganaMeLvl,     hiraganaReLvl,
         hiraganaMoLvl,     hiraganaRoLvl,

         hiraganaGaLvl,     hiraganaZaLvl,
         hiraganaGiLvl,     hiraganaJiLvl,
         hiraganaGuLvl,     hiraganaZuLvl,
         hiraganaGeLvl,     hiraganaZeLvl,
         hiraganaGoLvl,     hiraganaZoLvl,

         hiraganaDaLvl,     hiraganaBaLvl,
         hiraganaDiLvl,     hiraganaBiLvl,
         hiraganaDuLvl,     hiraganaBuLvl,
         hiraganaDeLvl,     hiraganaBeLvl,
         hiraganaDoLvl,     hiraganaBoLvl,

         hiraganaPaLvl,     hiraganaYaLvl,
         hiraganaPiLvl,     hiraganaYuLvl,
         hiraganaPuLvl,     hiraganaYoLvl,
         hiraganaPeLvl,     hiraganaWaLvl,
         hiraganaPoLvl,     hiraganaWoLvl,

         hiraganaKyaLvl,    hiraganaShaLvl,
         hiraganaKyuLvl,    hiraganaShuLvl,
         hiraganaKyoLvl,    hiraganaShoLvl,

         hiraganaChaLvl,    hiraganaHyaLvl,
         hiraganaChuLvl,    hiraganaHyuLvl,
         hiraganaChoLvl,    hiraganaHyoLvl,

         hiraganaNyaLvl,    hiraganaMyaLvl,
         hiraganaNyuLvl,    hiraganaMyuLvl,
         hiraganaNyoLvl,    hiraganaMyoLvl,

         hiraganaRyaLvl,    hiraganaGyaLvl,
         hiraganaRyuLvl,    hiraganaGyuLvl,
         hiraganaRyoLvl,    hiraganaGyoLvl,

         hiraganaJyaLvl,    hiraganaDyaLvl,
         hiraganaJyuLvl,    hiraganaDyuLvl,
         hiraganaJyoLvl,    hiraganaDyoLvl,

         hiraganaByaLvl,    hiraganaPyaLvl,
         hiraganaByuLvl,    hiraganaPyuLvl,
         hiraganaByoLvl,    hiraganaPyoLvl,

         hiraganaNLvl,

         katakanaALvl,     katakanaKaLVl,
         katakanaILvl,     katakanaKiLVl,
         katakanaULvl,     katakanaKuLVl,
         katakanaELvl,     katakanaKeLVl,
         katakanaOLvl,     katakanaKoLVl,

         katakanaSaLvl,    katakanaTaLvl,
         katakanaShiLvl,   katakanaChiLvl,
         katakanaSuLvl,    katakanaTsuLvl,
         katakanaSeLvl,    katakanaTeLvl,
         katakanaSoLvl,    katakanaToLvl,

         katakanaNaLvl,    katakanaHaLvl,
         katakanaNiLvl,    katakanaHiLvl,
         katakanaNuLvl,    katakanaHuLvl,
         katakanaNeLvl,    katakanaHeLvl,
         katakanaNoLvl,    katakanaHoLvl,

         katakanaMaLvl,    katakanaRaLvl,
         katakanaMiLvl,    katakanaRiLvl,
         katakanaMuLvl,    katakanaRuLvl,
         katakanaMeLvl,    katakanaReLvl,
         katakanaMoLvl,    katakanaRoLvl,

         katakanaGaLvl,    katakanaZaLvl,
         katakanaGiLvl,    katakanaZiLvl,
         katakanaGuLvl,    katakanaZuLvl,
         katakanaGeLvl,    katakanaZeLvl,
         katakanaGoLvl,    katakanaZoLvl,

         katakanaDaLvl,    katakanaBaLvl,
         katakanaDiLvl,    katakanaBiLvl,
         katakanaDuLvl,    katakanaBuLvl,
         katakanaDeLvl,    katakanaBeLvl,
         katakanaDoLvl,    katakanaBoLvl,

         katakanaPaLvl,    katakanaYaLvl,
         katakanaPiLvl,    katakanaYuLvl,
         katakanaPuLvl,    katakanaYoLvl,
         katakanaPeLvl,    katakanaWaLvl,
         katakanaPoLvl,    katakanaWoLvl,

         katakanaKyuLvl,    katakanaShaLvl,
         katakanaKyeLvl,    katakanaShuLvl,
         katakanaKyoLvl,    katakanaShoLvl,

         katakanaChaLvl,    katakanaHyaLvl,
         katakanaChuLvl,    katakanaHyuLvl,
         katakanaChoLvl,    katakanaHyoLvl,

         katakanaNyaLvl,    katakanaMyaLvl,
         katakanaNyuLvl,    katakanaMyuLvl,
         katakanaNyoLvl,    katakanaMyoLvl,

         katakanaRyaLvl,    katakanaGyaLvl,
         katakanaRyuLvl,    katakanaGyuLvl,
         katakanaRyoLvl,    katakanaGyoLvl,

         katakanaJyaLvl,    katakanaDyaLvl,
         katakanaJyuLvl,    katakanaDyuLvl,
         katakanaJyoLvl,    katakanaDyoLvl,

         katakanaByaLvl,    katakanaPyaLvl,
         katakanaByuLvl,    katakanaPyuLvl,
         katakanaByoLvl,    katakanaPyoLvl,

         katakanaNLvl;

     private static LetterLvlCounter instance = null;
     private Hashtable<String, Integer> hiraganaLvlTable;

     public static LetterLvlCounter getInstance() {
         if (instance == null) {
             instance = new LetterLvlCounter();
         }

         return instance;
     }


     private LetterLvlCounter(){
          initHiraganaTable();
     }

     private void initHiraganaTable(){

          hiraganaLvlTable = new Hashtable<String, Integer>();

          hiraganaLvlTable.put("hiraganaA", hiraganaALvl = 1);
          hiraganaLvlTable.put("hiraganaI", hiraganaILvl = 1);
          hiraganaLvlTable.put("hiraganaU", hiraganaULvl = 1);
          hiraganaLvlTable.put("hiraganaE", hiraganaELvl = 1);
          hiraganaLvlTable.put("hiraganaO", hiraganaOLvl = 1);
          hiraganaLvlTable.put("hiraganaKa", hiraganaKaLvl = 1);
          hiraganaLvlTable.put("hiraganaKi", hiraganaKiLvl = 1);
          hiraganaLvlTable.put("hiraganaKu", hiraganaKuLvl = 1);
          hiraganaLvlTable.put("hiraganaKe", hiraganaKeLvl = 1);
          hiraganaLvlTable.put("hiraganaKo", hiraganaKoLvl = 1);
          hiraganaLvlTable.put("hiraganaSa", hiraganaSaLvl = 1);
          hiraganaLvlTable.put("hiraganaShi", hiraganaShiLvl = 1);
          hiraganaLvlTable.put("hiraganaSu", hiraganaSuLvl = 1);
          hiraganaLvlTable.put("hiraganaSe", hiraganaSeLvl = 1);
          hiraganaLvlTable.put("hiraganaSo", hiraganaSoLvl = 1);
          hiraganaLvlTable.put("hiraganaTa", hiraganaTaLvl = 1);
          hiraganaLvlTable.put("hiraganaChi", hiraganaChiLvl = 1);
          hiraganaLvlTable.put("hiraganaTsu", hiraganaTsuLvl = 1);
          hiraganaLvlTable.put("hiraganaTe", hiraganaTeLvl = 1);
          hiraganaLvlTable.put("hiraganaTo", hiraganaToLvl = 1);
          hiraganaLvlTable.put("hiraganaNa", hiraganaNaLvl = 1);
          hiraganaLvlTable.put("hiraganaNi", hiraganaNiLvl = 1);
          hiraganaLvlTable.put("hiraganaNu", hiraganaNuLvl = 1);
          hiraganaLvlTable.put("hiraganaNe", hiraganaNeLvl = 1);
          hiraganaLvlTable.put("hiraganaNo", hiraganaNoLvl = 1);
          hiraganaLvlTable.put("hiraganaHa", hiraganaHaLvl = 1);
          hiraganaLvlTable.put("hiraganaHi", hiraganaHiLvl = 1);
          hiraganaLvlTable.put("hiraganaHu", hiraganaHuLvl = 1);
          hiraganaLvlTable.put("hiraganaHe", hiraganaHeLvl = 1);
          hiraganaLvlTable.put("hiraganaHo", hiraganaHoLvl = 1);
          hiraganaLvlTable.put("hiraganaMa", hiraganaMaLvl = 1);
          hiraganaLvlTable.put("hiraganaMi", hiraganaMiLvl = 1);
          hiraganaLvlTable.put("hiraganaMu", hiraganaMuLvl = 1);
          hiraganaLvlTable.put("hiraganaMe", hiraganaMeLvl = 1);
          hiraganaLvlTable.put("hiraganaMo", hiraganaMoLvl = 1);
          hiraganaLvlTable.put("hiraganaRa", hiraganaRaLvl = 1);
          hiraganaLvlTable.put("hiraganaRi", hiraganaRiLvl = 1);
          hiraganaLvlTable.put("hiraganaRu", hiraganaRuLvl = 1);
          hiraganaLvlTable.put("hiraganaRe", hiraganaReLvl = 1);
          hiraganaLvlTable.put("hiraganaRo", hiraganaRoLvl = 1);
          hiraganaLvlTable.put("hiraganaGa", hiraganaGaLvl = 1);
          hiraganaLvlTable.put("hiraganaGi", hiraganaGiLvl = 1);
          hiraganaLvlTable.put("hiraganaGu", hiraganaGuLvl = 1);
          hiraganaLvlTable.put("hiraganaGe", hiraganaGeLvl = 1);
          hiraganaLvlTable.put("hiraganaGo", hiraganaGoLvl = 1);
          hiraganaLvlTable.put("hiraganaZa", hiraganaZaLvl = 1);
          hiraganaLvlTable.put("hiraganaJi", hiraganaJiLvl = 1);
          hiraganaLvlTable.put("hiraganaZu", hiraganaZuLvl = 1);
          hiraganaLvlTable.put("hiraganaZe", hiraganaZeLvl = 1);
          hiraganaLvlTable.put("hiraganaZo", hiraganaZoLvl = 1);
          hiraganaLvlTable.put("hiraganaDa", hiraganaDaLvl = 1);
          hiraganaLvlTable.put("hiraganaDi", hiraganaDiLvl = 1);
          hiraganaLvlTable.put("hiraganaDu", hiraganaDuLvl = 1);
          hiraganaLvlTable.put("hiraganaDe", hiraganaDeLvl = 1);
          hiraganaLvlTable.put("hiraganaDo", hiraganaDoLvl = 1);
          hiraganaLvlTable.put("hiraganaBa", hiraganaBaLvl = 1);
          hiraganaLvlTable.put("hiraganaBi", hiraganaBiLvl = 1);
          hiraganaLvlTable.put("hiraganaBu", hiraganaBuLvl = 1);
          hiraganaLvlTable.put("hiraganaBe", hiraganaBeLvl = 1);
          hiraganaLvlTable.put("hiraganaBo", hiraganaBoLvl = 1);
          hiraganaLvlTable.put("hiraganaPa", hiraganaPaLvl = 1);
          hiraganaLvlTable.put("hiraganaPi", hiraganaPiLvl = 1);
          hiraganaLvlTable.put("hiraganaPu", hiraganaPuLvl = 1);
          hiraganaLvlTable.put("hiraganaPe", hiraganaPeLvl = 1);
          hiraganaLvlTable.put("hiraganaPo", hiraganaPoLvl = 1);
          hiraganaLvlTable.put("hiraganaYa", hiraganaYaLvl = 1);
          hiraganaLvlTable.put("hiraganaYu", hiraganaYuLvl = 1);
          hiraganaLvlTable.put("hiraganaYo", hiraganaYoLvl = 1);
          hiraganaLvlTable.put("hiraganaWa", hiraganaWaLvl = 1);
          hiraganaLvlTable.put("hiraganaWo", hiraganaWoLvl = 1);
          hiraganaLvlTable.put("hiraganaKya", hiraganaKyaLvl = 1);
          hiraganaLvlTable.put("hiraganaKyu", hiraganaKyuLvl = 1);
          hiraganaLvlTable.put("hiraganaKyo", hiraganaKyoLvl = 1);
          hiraganaLvlTable.put("hiraganaSha", hiraganaShaLvl = 1);
          hiraganaLvlTable.put("hiraganaShu", hiraganaShuLvl = 1);
          hiraganaLvlTable.put("hiraganaSho", hiraganaShoLvl = 1);
          hiraganaLvlTable.put("hiraganaCha", hiraganaChaLvl = 1);
          hiraganaLvlTable.put("hiraganaChu", hiraganaChuLvl = 1);
          hiraganaLvlTable.put("hiraganaCho", hiraganaChoLvl = 1);
          hiraganaLvlTable.put("hiraganaHya", hiraganaHyaLvl = 1);
          hiraganaLvlTable.put("hiraganaHyu", hiraganaHyuLvl = 1);
          hiraganaLvlTable.put("hiraganaHyo", hiraganaHyoLvl = 1);
          hiraganaLvlTable.put("hiraganaNya", hiraganaNyaLvl = 1);
          hiraganaLvlTable.put("hiraganaNyu", hiraganaNyuLvl = 1);
          hiraganaLvlTable.put("hiraganaNyo", hiraganaNyoLvl = 1);
          hiraganaLvlTable.put("hiraganaMya",  hiraganaMyaLvl = 1);
          hiraganaLvlTable.put("hiraganaMyu",  hiraganaMyuLvl = 1);
          hiraganaLvlTable.put("hiraganaMyo",  hiraganaMyoLvl = 1);
          hiraganaLvlTable.put("hiraganaRya", hiraganaRyaLvl = 1);
          hiraganaLvlTable.put("hiraganaRyu", hiraganaRyuLvl = 1);
          hiraganaLvlTable.put("hiraganaRyo", hiraganaRyoLvl = 1);
          hiraganaLvlTable.put("hiraganaGya", hiraganaGyaLvl = 1);
          hiraganaLvlTable.put("hiraganaGyu", hiraganaGyuLvl = 1);
          hiraganaLvlTable.put("hiraganaGyo", hiraganaGyoLvl = 1);
          hiraganaLvlTable.put("hiraganaJya", hiraganaJyaLvl = 1);
          hiraganaLvlTable.put("hiraganaJyu", hiraganaJyuLvl = 1);
          hiraganaLvlTable.put("hiraganaJyo", hiraganaJyoLvl = 1);
          hiraganaLvlTable.put("hiraganaDya", hiraganaDyaLvl = 1);
          hiraganaLvlTable.put("hiraganaDyu", hiraganaDyuLvl = 1);
          hiraganaLvlTable.put("hiraganaDyo", hiraganaDyoLvl = 1);
          hiraganaLvlTable.put("hiraganaBya", hiraganaByaLvl = 1);
          hiraganaLvlTable.put("hiraganaByu", hiraganaByuLvl = 1);
          hiraganaLvlTable.put("hiraganaByo", hiraganaByoLvl = 1);
          hiraganaLvlTable.put("hiraganaPya", hiraganaPyaLvl = 1);
          hiraganaLvlTable.put("hiraganaPyu", hiraganaPyuLvl = 1);
          hiraganaLvlTable.put("hiraganaPyo", hiraganaPyoLvl = 1);
          hiraganaLvlTable.put("hiraganaN", hiraganaNLvl = 1);

     }

     public Hashtable<String, Integer> getHiraganaLvlTable() {
          return hiraganaLvlTable;
     }
}
