package com.mygdx.game.japanese;


import java.util.Hashtable;

/**
 * Created by firasAltayeb on 07/04/2017.
 */

public class LetterLvlCounter {

    public static int
         hiraganaALvl = 1,      hiraganaKaLvl = 1,
         hiraganaILvl = 1,      hiraganaKiLvl = 1,
         hiraganaULvl = 1,      hiraganaKuLvl = 1,
         hiraganaELvl = 1,      hiraganaKeLvl = 1,
         hiraganaOLvl = 1,      hiraganaKoLvl = 1,

         hiraganaSaLvl = 1,     hiraganaTaLvl = 1,
         hiraganaShiLvl = 1,    hiraganaChiLvl = 1,
         hiraganaSuLvl = 1,     hiraganaTsuLvl = 1,
         hiraganaSeLvl = 1,     hiraganaTeLvl = 1,
         hiraganaSoLvl = 1,     hiraganaToLvl = 1,

         hiraganaNaLvl = 1,     hiraganaHaLvl = 1,
         hiraganaNiLvl = 1,     hiraganaHiLvl = 1,
         hiraganaNuLvl = 1,     hiraganaHuLvl = 1,
         hiraganaNeLvl = 1,     hiraganaHeLvl = 1,
         hiraganaNoLvl = 1,     hiraganaHoLvl = 1,

         hiraganaMaLvl = 1,     hiraganaRaLvl = 1,
         hiraganaMiLvl = 1,     hiraganaRiLvl = 1,
         hiraganaMuLvl = 1,     hiraganaRuLvl = 1,
         hiraganaMeLvl = 1,     hiraganaReLvl = 1,
         hiraganaMoLvl = 1,     hiraganaRoLvl = 1,

         hiraganaNLvl  = 1,

         hiraganaGaLvl = 1,     hiraganaZaLvl = 1,
         hiraganaGiLvl = 1,     hiraganaJiLvl = 1,
         hiraganaGuLvl = 1,     hiraganaZuLvl = 1,
         hiraganaGeLvl = 1,     hiraganaZeLvl = 1,
         hiraganaGoLvl = 1,     hiraganaZoLvl = 1,

         hiraganaDaLvl = 1,     hiraganaBaLvl = 1,
         hiraganaDiLvl = 1,     hiraganaBiLvl = 1,
         hiraganaDuLvl = 1,     hiraganaBuLvl = 1,
         hiraganaDeLvl = 1,     hiraganaBeLvl = 1,
         hiraganaDoLvl = 1,     hiraganaBoLvl = 1,

         hiraganaPaLvl = 1,     hiraganaYaLvl = 1,
         hiraganaPiLvl = 1,     hiraganaYuLvl = 1,
         hiraganaPuLvl = 1,     hiraganaYoLvl = 1,
         hiraganaPeLvl = 1,     hiraganaWaLvl = 1,
         hiraganaPoLvl = 1,     hiraganaWoLvl = 1,

         hiraganaKyaLvl = 1,    hiraganaShaLvl = 1,
         hiraganaKyuLvl = 1,    hiraganaShuLvl = 1,
         hiraganaKyoLvl = 1,    hiraganaShoLvl = 1,

         hiraganaChaLvl = 1,    hiraganaHyaLvl = 1,
         hiraganaChuLvl = 1,    hiraganaHyuLvl = 1,
         hiraganaChoLvl = 1,    hiraganaHyoLvl = 1,

         hiraganaNyaLvl = 1,    hiraganaMyaLvl = 1,
         hiraganaNyuLvl = 1,    hiraganaMyuLvl = 1,
         hiraganaNyoLvl = 1,    hiraganaMyoLvl = 1,

         hiraganaRyaLvl = 1,    hiraganaGyaLvl = 1,
         hiraganaRyuLvl = 1,    hiraganaGyuLvl = 1,
         hiraganaRyoLvl = 1,    hiraganaGyoLvl = 1,

         hiraganaJyaLvl = 1,    hiraganaDyaLvl = 1,
         hiraganaJyuLvl = 1,    hiraganaDyuLvl = 1,
         hiraganaJyoLvl = 1,    hiraganaDyoLvl = 1,

         hiraganaByaLvl = 1,    hiraganaPyaLvl = 1,
         hiraganaByuLvl = 1,    hiraganaPyuLvl = 1,
         hiraganaByoLvl = 1,    hiraganaPyoLvl = 1,

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

         katakanaNLvl = 1;

     private static boolean allHiraganaMemorised = false;
     private static Hashtable<String, Integer> hiraganaLvlTable;


     public static Hashtable<String, Integer> getHiraganaLvlTable(){

          hiraganaLvlTable = new Hashtable<String, Integer>();

          hiraganaLvlTable.put("hiraganaA", hiraganaALvl);
          hiraganaLvlTable.put("hiraganaI", hiraganaILvl);
          hiraganaLvlTable.put("hiraganaU", hiraganaULvl);
          hiraganaLvlTable.put("hiraganaE", hiraganaELvl);
          hiraganaLvlTable.put("hiraganaO", hiraganaOLvl);
          hiraganaLvlTable.put("hiraganaKa", hiraganaKaLvl);
          hiraganaLvlTable.put("hiraganaKi", hiraganaKiLvl);
          hiraganaLvlTable.put("hiraganaKu", hiraganaKuLvl);
          hiraganaLvlTable.put("hiraganaKe", hiraganaKeLvl);
          hiraganaLvlTable.put("hiraganaKo", hiraganaKoLvl);
          hiraganaLvlTable.put("hiraganaSa", hiraganaSaLvl);
          hiraganaLvlTable.put("hiraganaShi", hiraganaShiLvl);
          hiraganaLvlTable.put("hiraganaSu", hiraganaSuLvl);
          hiraganaLvlTable.put("hiraganaSe", hiraganaSeLvl);
          hiraganaLvlTable.put("hiraganaSo", hiraganaSoLvl);
          hiraganaLvlTable.put("hiraganaTa", hiraganaTaLvl);
          hiraganaLvlTable.put("hiraganaChi", hiraganaChiLvl);
          hiraganaLvlTable.put("hiraganaTsu", hiraganaTsuLvl);
          hiraganaLvlTable.put("hiraganaTe", hiraganaTeLvl);
          hiraganaLvlTable.put("hiraganaTo", hiraganaToLvl);
          hiraganaLvlTable.put("hiraganaNa", hiraganaNaLvl);
          hiraganaLvlTable.put("hiraganaNi", hiraganaNiLvl);
          hiraganaLvlTable.put("hiraganaNu", hiraganaNuLvl);
          hiraganaLvlTable.put("hiraganaNe", hiraganaNeLvl);
          hiraganaLvlTable.put("hiraganaNo", hiraganaNoLvl);
          hiraganaLvlTable.put("hiraganaHa", hiraganaHaLvl);
          hiraganaLvlTable.put("hiraganaHi", hiraganaHiLvl);
          hiraganaLvlTable.put("hiraganaHu", hiraganaHuLvl);
          hiraganaLvlTable.put("hiraganaHe", hiraganaHeLvl);
          hiraganaLvlTable.put("hiraganaHo", hiraganaHoLvl);
          hiraganaLvlTable.put("hiraganaMa", hiraganaMaLvl);
          hiraganaLvlTable.put("hiraganaMi", hiraganaMiLvl);
          hiraganaLvlTable.put("hiraganaMu", hiraganaMuLvl);
          hiraganaLvlTable.put("hiraganaMe", hiraganaMeLvl);
          hiraganaLvlTable.put("hiraganaMo", hiraganaMoLvl);
          hiraganaLvlTable.put("hiraganaRa", hiraganaRaLvl);
          hiraganaLvlTable.put("hiraganaRi", hiraganaRiLvl);
          hiraganaLvlTable.put("hiraganaRu", hiraganaRuLvl);
          hiraganaLvlTable.put("hiraganaRe", hiraganaReLvl);
          hiraganaLvlTable.put("hiraganaRo", hiraganaRoLvl);
          hiraganaLvlTable.put("hiraganaYu", hiraganaYuLvl);
          hiraganaLvlTable.put("hiraganaYo", hiraganaYoLvl);
          hiraganaLvlTable.put("hiraganaWa", hiraganaWaLvl);
          hiraganaLvlTable.put("hiraganaWo", hiraganaWoLvl);

          hiraganaLvlTable.put("hiraganaN", hiraganaNLvl);

          hiraganaLvlTable.put("hiraganaGa", hiraganaGaLvl);
          hiraganaLvlTable.put("hiraganaGi", hiraganaGiLvl);
          hiraganaLvlTable.put("hiraganaGu", hiraganaGuLvl);
          hiraganaLvlTable.put("hiraganaGe", hiraganaGeLvl);
          hiraganaLvlTable.put("hiraganaGo", hiraganaGoLvl);
          hiraganaLvlTable.put("hiraganaZa", hiraganaZaLvl);
          hiraganaLvlTable.put("hiraganaJi", hiraganaJiLvl);
          hiraganaLvlTable.put("hiraganaZu", hiraganaZuLvl);
          hiraganaLvlTable.put("hiraganaZe", hiraganaZeLvl);
          hiraganaLvlTable.put("hiraganaZo", hiraganaZoLvl);
          hiraganaLvlTable.put("hiraganaDa", hiraganaDaLvl);
          hiraganaLvlTable.put("hiraganaDi", hiraganaDiLvl);
          hiraganaLvlTable.put("hiraganaDu", hiraganaDuLvl);
          hiraganaLvlTable.put("hiraganaDe", hiraganaDeLvl);
          hiraganaLvlTable.put("hiraganaDo", hiraganaDoLvl);
          hiraganaLvlTable.put("hiraganaBa", hiraganaBaLvl);
          hiraganaLvlTable.put("hiraganaBi", hiraganaBiLvl);
          hiraganaLvlTable.put("hiraganaBu", hiraganaBuLvl);
          hiraganaLvlTable.put("hiraganaBe", hiraganaBeLvl);
          hiraganaLvlTable.put("hiraganaBo", hiraganaBoLvl);
          hiraganaLvlTable.put("hiraganaPa", hiraganaPaLvl);
          hiraganaLvlTable.put("hiraganaPi", hiraganaPiLvl);
          hiraganaLvlTable.put("hiraganaPu", hiraganaPuLvl);
          hiraganaLvlTable.put("hiraganaPe", hiraganaPeLvl);
          hiraganaLvlTable.put("hiraganaPo", hiraganaPoLvl);
          hiraganaLvlTable.put("hiraganaYa", hiraganaYaLvl);
          hiraganaLvlTable.put("hiraganaKya", hiraganaKyaLvl);
          hiraganaLvlTable.put("hiraganaKyu", hiraganaKyuLvl);
          hiraganaLvlTable.put("hiraganaKyo", hiraganaKyoLvl);
          hiraganaLvlTable.put("hiraganaSha", hiraganaShaLvl);
          hiraganaLvlTable.put("hiraganaShu", hiraganaShuLvl);
          hiraganaLvlTable.put("hiraganaSho", hiraganaShoLvl);
          hiraganaLvlTable.put("hiraganaCha", hiraganaChaLvl);
          hiraganaLvlTable.put("hiraganaChu", hiraganaChuLvl);
          hiraganaLvlTable.put("hiraganaCho", hiraganaChoLvl);
          hiraganaLvlTable.put("hiraganaHya", hiraganaHyaLvl);
          hiraganaLvlTable.put("hiraganaHyu", hiraganaHyuLvl);
          hiraganaLvlTable.put("hiraganaHyo", hiraganaHyoLvl);
          hiraganaLvlTable.put("hiraganaNya", hiraganaNyaLvl);
          hiraganaLvlTable.put("hiraganaNyu", hiraganaNyuLvl);
          hiraganaLvlTable.put("hiraganaNyo", hiraganaNyoLvl);
          hiraganaLvlTable.put("hiraganaMya", hiraganaMyaLvl);
          hiraganaLvlTable.put("hiraganaMyu", hiraganaMyuLvl);
          hiraganaLvlTable.put("hiraganaMyo", hiraganaMyoLvl);
          hiraganaLvlTable.put("hiraganaRya", hiraganaRyaLvl);
          hiraganaLvlTable.put("hiraganaRyu", hiraganaRyuLvl);
          hiraganaLvlTable.put("hiraganaRyo", hiraganaRyoLvl);
          hiraganaLvlTable.put("hiraganaGya", hiraganaGyaLvl);
          hiraganaLvlTable.put("hiraganaGyu", hiraganaGyuLvl);
          hiraganaLvlTable.put("hiraganaGyo", hiraganaGyoLvl);
          hiraganaLvlTable.put("hiraganaJya", hiraganaJyaLvl);
          hiraganaLvlTable.put("hiraganaJyu", hiraganaJyuLvl);
          hiraganaLvlTable.put("hiraganaJyo", hiraganaJyoLvl);
          hiraganaLvlTable.put("hiraganaDya", hiraganaDyaLvl);
          hiraganaLvlTable.put("hiraganaDyu", hiraganaDyuLvl);
          hiraganaLvlTable.put("hiraganaDyo", hiraganaDyoLvl);
          hiraganaLvlTable.put("hiraganaBya", hiraganaByaLvl);
          hiraganaLvlTable.put("hiraganaByu", hiraganaByuLvl);
          hiraganaLvlTable.put("hiraganaByo", hiraganaByoLvl);
          hiraganaLvlTable.put("hiraganaPya", hiraganaPyaLvl);
          hiraganaLvlTable.put("hiraganaPyu", hiraganaPyuLvl);
          hiraganaLvlTable.put("hiraganaPyo", hiraganaPyoLvl);

          return hiraganaLvlTable;
     }

     public static void increaseLvl(String letter){
          switch (letter){
               case "hiraganaA":       hiraganaALvl++;    break;
               case "hiraganaI":       hiraganaILvl++;    break;
               case "hiraganaU":       hiraganaULvl++;    break;
               case "hiraganaE":       hiraganaELvl++;    break;
               case "hiraganaO":       hiraganaOLvl++;    break;
               case "hiraganaKa":      hiraganaKaLvl++;     break;
               case "hiraganaKi":      hiraganaKiLvl++;     break;
               case "hiraganaKu":      hiraganaKuLvl++;     break;
               case "hiraganaKe":      hiraganaKeLvl++;     break;
               case "hiraganaKo":      hiraganaKoLvl++;     break;
               case "hiraganaSa":      hiraganaSaLvl++;     break;
               case "hiraganaShi":     hiraganaShiLvl++;    break;
               case "hiraganaSu":      hiraganaSuLvl++;     break;
               case "hiraganaSe":      hiraganaSeLvl++;     break;
               case "hiraganaSo":      hiraganaSoLvl++;     break;
               case "hiraganaTa":      hiraganaTaLvl++;     break;
               case "hiraganaChi":     hiraganaChiLvl++;    break;
               case "hiraganaTsu":     hiraganaTsuLvl++;    break;
               case "hiraganaTe":      hiraganaTeLvl++;     break;
               case "hiraganaTo":      hiraganaToLvl++;     break;
               case "hiraganaNa":      hiraganaNaLvl++;     break;
               case "hiraganaNi":      hiraganaNiLvl++;     break;
               case "hiraganaNu":      hiraganaNuLvl++;     break;
               case "hiraganaNe":      hiraganaNeLvl++;     break;
               case "hiraganaNo":      hiraganaNoLvl++;     break;
               case "hiraganaHa":      hiraganaHaLvl++;     break;
               case "hiraganaHi":      hiraganaHiLvl++;     break;
               case "hiraganaHu":      hiraganaHuLvl++;     break;
               case "hiraganaHe":      hiraganaHeLvl++;     break;
               case "hiraganaHo":      hiraganaHoLvl++;     break;
               case "hiraganaMa":      hiraganaMaLvl++;     break;
               case "hiraganaMi":      hiraganaMiLvl++;     break;
               case "hiraganaMu":      hiraganaMuLvl++;     break;
               case "hiraganaMe":      hiraganaMeLvl++;     break;
               case "hiraganaMo":      hiraganaMoLvl++;     break;
               case "hiraganaRa":      hiraganaRaLvl++;     break;
               case "hiraganaRi":      hiraganaRiLvl++;     break;
               case "hiraganaRu":      hiraganaRuLvl++;     break;
               case "hiraganaRe":      hiraganaReLvl++;     break;
               case "hiraganaRo":      hiraganaRoLvl++;     break;
               case "hiraganaYa":      hiraganaYaLvl++;     break;
               case "hiraganaYu":      hiraganaYuLvl++;     break;
               case "hiraganaYo":      hiraganaYoLvl++;     break;
               case "hiraganaWa":      hiraganaWaLvl++;     break;
               case "hiraganaWo":      hiraganaWoLvl++;     break;
               case "hiraganaN":       hiraganaNLvl++;      break;
               case "hiraganaGa":      hiraganaGaLvl++;     break;
               case "hiraganaGi":      hiraganaGiLvl++;     break;
               case "hiraganaGu":      hiraganaGuLvl++;     break;
               case "hiraganaGe":      hiraganaGeLvl++;     break;
               case "hiraganaGo":      hiraganaGoLvl++;     break;
               case "hiraganaZa":      hiraganaZaLvl++;     break;
               case "hiraganaJi":      hiraganaJiLvl++;     break;
               case "hiraganaZu":      hiraganaZuLvl++;     break;
               case "hiraganaZe":      hiraganaZeLvl++;     break;
               case "hiraganaZo":      hiraganaZoLvl++;     break;
               case "hiraganaDa":      hiraganaDaLvl++;     break;
               case "hiraganaDi":      hiraganaDiLvl++;     break;
               case "hiraganaDu":      hiraganaDuLvl++;     break;
               case "hiraganaDe":      hiraganaDeLvl++;     break;
               case "hiraganaDo":      hiraganaDoLvl++;     break;
               case "hiraganaBa":      hiraganaBaLvl++;     break;
               case "hiraganaBi":      hiraganaBiLvl++;     break;
               case "hiraganaBu":      hiraganaBuLvl++;     break;
               case "hiraganaBe":      hiraganaBeLvl++;     break;
               case "hiraganaBo":      hiraganaBoLvl++;     break;
               case "hiraganaPa":      hiraganaPaLvl++;     break;
               case "hiraganaPi":      hiraganaPiLvl++;     break;
               case "hiraganaPu":      hiraganaPuLvl++;     break;
               case "hiraganaPe":      hiraganaPeLvl++;     break;
               case "hiraganaPo":      hiraganaPoLvl++;     break;
               case "hiraganaKya":     hiraganaKyaLvl++;     break;
               case "hiraganaKyu":     hiraganaKyuLvl++;     break;
               case "hiraganaKyo":     hiraganaKyoLvl++;     break;
               case "hiraganaSha":     hiraganaShaLvl++;     break;
               case "hiraganaShu":     hiraganaShuLvl++;     break;
               case "hiraganaSho":     hiraganaShoLvl++;     break;
               case "hiraganaCha":     hiraganaChaLvl++;     break;
               case "hiraganaChu":     hiraganaChuLvl++;     break;
               case "hiraganaCho":     hiraganaChoLvl++;     break;
               case "hiraganaHya":     hiraganaHyaLvl++;     break;
               case "hiraganaHyu":     hiraganaHyuLvl++;     break;
               case "hiraganaHyo":     hiraganaHyoLvl++;     break;
               case "hiraganaNya":     hiraganaNyaLvl++;     break;
               case "hiraganaNyu":     hiraganaNyuLvl++;     break;
               case "hiraganaNyo":     hiraganaNyoLvl++;     break;
               case "hiraganaMya":     hiraganaMyaLvl++;     break;
               case "hiraganaMyu":     hiraganaMyuLvl++;     break;
               case "hiraganaMyo":     hiraganaMyoLvl++;     break;
               case "hiraganaRya":     hiraganaRyaLvl++;     break;
               case "hiraganaRyu":     hiraganaRyuLvl++;     break;
               case "hiraganaRyo":     hiraganaRyoLvl++;     break;
               case "hiraganaGya":     hiraganaGyaLvl++;     break;
               case "hiraganaGyu":     hiraganaGyuLvl++;     break;
               case "hiraganaGyo":     hiraganaGyoLvl++;     break;
               case "hiraganaJya":     hiraganaJyaLvl++;     break;
               case "hiraganaJyu":     hiraganaJyuLvl++;     break;
               case "hiraganaJyo":     hiraganaJyoLvl++;     break;
               case "hiraganaDya":     hiraganaDyaLvl++;     break;
               case "hiraganaDyu":     hiraganaDyuLvl++;     break;
               case "hiraganaDyo":     hiraganaDyoLvl++;     break;
               case "hiraganaBya":     hiraganaByaLvl++;     break;
               case "hiraganaByu":     hiraganaByuLvl++;     break;
               case "hiraganaByo":     hiraganaByoLvl++;     break;
               case "hiraganaPya":     hiraganaPyaLvl++;     break;
               case "hiraganaPyu":     hiraganaPyuLvl++;     break;
               case "hiraganaPyo":     hiraganaPyoLvl++;     break;
               default: break;

          }
     }

     public static boolean isAllHiraganaMemorised(){
          return allHiraganaMemorised;
     }

     public static void setAllHiraganaMemorisedToTrue(){

          allHiraganaMemorised = true;

          hiraganaALvl = 3;      hiraganaKaLvl = 3;
          hiraganaILvl = 3;      hiraganaKiLvl = 3;
          hiraganaULvl = 3;      hiraganaKuLvl = 3;
          hiraganaELvl = 3;      hiraganaKeLvl = 3;
          hiraganaOLvl = 3;      hiraganaKoLvl = 3;

          hiraganaSaLvl = 3;     hiraganaTaLvl = 3;
          hiraganaShiLvl = 3;    hiraganaChiLvl = 3;
          hiraganaSuLvl = 3;     hiraganaTsuLvl = 3;
          hiraganaSeLvl = 3;     hiraganaTeLvl = 3;
          hiraganaSoLvl = 3;     hiraganaToLvl = 3;

          hiraganaNaLvl = 3;     hiraganaHaLvl = 3;
          hiraganaNiLvl = 3;     hiraganaHiLvl = 3;
          hiraganaNuLvl = 3;     hiraganaHuLvl = 3;
          hiraganaNeLvl = 3;     hiraganaHeLvl = 3;
          hiraganaNoLvl = 3;     hiraganaHoLvl = 3;

          hiraganaMaLvl = 3;     hiraganaRaLvl = 3;
          hiraganaMiLvl = 3;     hiraganaRiLvl = 3;
          hiraganaMuLvl = 3;     hiraganaRuLvl = 3;
          hiraganaMeLvl = 3;     hiraganaReLvl = 3;
          hiraganaMoLvl = 3;     hiraganaRoLvl = 3;

          hiraganaNLvl  = 3;

          hiraganaGaLvl = 3;     hiraganaZaLvl = 3;
          hiraganaGiLvl = 3;     hiraganaJiLvl = 3;
          hiraganaGuLvl = 3;     hiraganaZuLvl = 3;
          hiraganaGeLvl = 3;     hiraganaZeLvl = 3;
          hiraganaGoLvl = 3;     hiraganaZoLvl = 3;

          hiraganaDaLvl = 3;     hiraganaBaLvl = 3;
          hiraganaDiLvl = 3;     hiraganaBiLvl = 3;
          hiraganaDuLvl = 3;     hiraganaBuLvl = 3;
          hiraganaDeLvl = 3;     hiraganaBeLvl = 3;
          hiraganaDoLvl = 3;     hiraganaBoLvl = 3;

          hiraganaPaLvl = 3;     hiraganaYaLvl = 3;
          hiraganaPiLvl = 3;     hiraganaYuLvl = 3;
          hiraganaPuLvl = 3;     hiraganaYoLvl = 3;
          hiraganaPeLvl = 3;     hiraganaWaLvl = 3;
          hiraganaPoLvl = 3;     hiraganaWoLvl = 3;

          hiraganaKyaLvl = 3;    hiraganaShaLvl = 3;
          hiraganaKyuLvl = 3;    hiraganaShuLvl = 3;
          hiraganaKyoLvl = 3;    hiraganaShoLvl = 3;

          hiraganaChaLvl = 3;    hiraganaHyaLvl = 3;
          hiraganaChuLvl = 3;    hiraganaHyuLvl = 3;
          hiraganaChoLvl = 3;    hiraganaHyoLvl = 3;

          hiraganaNyaLvl = 3;    hiraganaMyaLvl = 3;
          hiraganaNyuLvl = 3;    hiraganaMyuLvl = 3;
          hiraganaNyoLvl = 3;    hiraganaMyoLvl = 3;

          hiraganaRyaLvl = 3;    hiraganaGyaLvl = 3;
          hiraganaRyuLvl = 3;    hiraganaGyuLvl = 3;
          hiraganaRyoLvl = 3;    hiraganaGyoLvl = 3;

          hiraganaJyaLvl = 3;    hiraganaDyaLvl = 3;
          hiraganaJyuLvl = 3;    hiraganaDyuLvl = 3;
          hiraganaJyoLvl = 3;    hiraganaDyoLvl = 3;

          hiraganaByaLvl = 3;    hiraganaPyaLvl = 3;
          hiraganaByuLvl = 3;    hiraganaPyuLvl = 3;
          hiraganaByoLvl = 3;    hiraganaPyoLvl = 3;

     }

     public static void setAllHiraganaMemorisedToFalse(){

          allHiraganaMemorised = false;

          hiraganaALvl = 1;      hiraganaKaLvl = 1;
          hiraganaILvl = 1;      hiraganaKiLvl = 1;
          hiraganaULvl = 1;      hiraganaKuLvl = 1;
          hiraganaELvl = 1;      hiraganaKeLvl = 1;
          hiraganaOLvl = 1;      hiraganaKoLvl = 1;

          hiraganaSaLvl = 1;     hiraganaTaLvl = 1;
          hiraganaShiLvl = 1;    hiraganaChiLvl = 1;
          hiraganaSuLvl = 1;     hiraganaTsuLvl = 1;
          hiraganaSeLvl = 1;     hiraganaTeLvl = 1;
          hiraganaSoLvl = 1;     hiraganaToLvl = 1;

          hiraganaNaLvl = 1;     hiraganaHaLvl = 1;
          hiraganaNiLvl = 1;     hiraganaHiLvl = 1;
          hiraganaNuLvl = 1;     hiraganaHuLvl = 1;
          hiraganaNeLvl = 1;     hiraganaHeLvl = 1;
          hiraganaNoLvl = 1;     hiraganaHoLvl = 1;

          hiraganaMaLvl = 1;     hiraganaRaLvl = 1;
          hiraganaMiLvl = 1;     hiraganaRiLvl = 1;
          hiraganaMuLvl = 1;     hiraganaRuLvl = 1;
          hiraganaMeLvl = 1;     hiraganaReLvl = 1;
          hiraganaMoLvl = 1;     hiraganaRoLvl = 1;

          hiraganaNLvl  = 1;

          hiraganaGaLvl = 1;     hiraganaZaLvl = 1;
          hiraganaGiLvl = 1;     hiraganaJiLvl = 1;
          hiraganaGuLvl = 1;     hiraganaZuLvl = 1;
          hiraganaGeLvl = 1;     hiraganaZeLvl = 1;
          hiraganaGoLvl = 1;     hiraganaZoLvl = 1;

          hiraganaDaLvl = 1;     hiraganaBaLvl = 1;
          hiraganaDiLvl = 1;     hiraganaBiLvl = 1;
          hiraganaDuLvl = 1;     hiraganaBuLvl = 1;
          hiraganaDeLvl = 1;     hiraganaBeLvl = 1;
          hiraganaDoLvl = 1;     hiraganaBoLvl = 1;

          hiraganaPaLvl = 1;     hiraganaYaLvl = 1;
          hiraganaPiLvl = 1;     hiraganaYuLvl = 1;
          hiraganaPuLvl = 1;     hiraganaYoLvl = 1;
          hiraganaPeLvl = 1;     hiraganaWaLvl = 1;
          hiraganaPoLvl = 1;     hiraganaWoLvl = 1;

          hiraganaKyaLvl = 1;    hiraganaShaLvl = 1;
          hiraganaKyuLvl = 1;    hiraganaShuLvl = 1;
          hiraganaKyoLvl = 1;    hiraganaShoLvl = 1;

          hiraganaChaLvl = 1;    hiraganaHyaLvl = 1;
          hiraganaChuLvl = 1;    hiraganaHyuLvl = 1;
          hiraganaChoLvl = 1;    hiraganaHyoLvl = 1;

          hiraganaNyaLvl = 1;    hiraganaMyaLvl = 1;
          hiraganaNyuLvl = 1;    hiraganaMyuLvl = 1;
          hiraganaNyoLvl = 1;    hiraganaMyoLvl = 1;

          hiraganaRyaLvl = 1;    hiraganaGyaLvl = 1;
          hiraganaRyuLvl = 1;    hiraganaGyuLvl = 1;
          hiraganaRyoLvl = 1;    hiraganaGyoLvl = 1;

          hiraganaJyaLvl = 1;    hiraganaDyaLvl = 1;
          hiraganaJyuLvl = 1;    hiraganaDyuLvl = 1;
          hiraganaJyoLvl = 1;    hiraganaDyoLvl = 1;

          hiraganaByaLvl = 1;    hiraganaPyaLvl = 1;
          hiraganaByuLvl = 1;    hiraganaPyuLvl = 1;
          hiraganaByoLvl = 1;    hiraganaPyoLvl = 1;

     }
}
