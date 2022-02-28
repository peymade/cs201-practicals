package week2;

public class Song {
  // have at least five instance variables on your class.

  private String name;
  private String artist;
  private String genre;
  private String minutes;
  private String seconds;
  private String length;

  public Song(String name, String artist, String genre, String minutes, String seconds) {
    this.name = name;
    this.artist = artist;
    this.genre = genre;
    this.minutes = minutes;
    this.seconds = seconds;

    this.length = this.minutes + ":" + this.seconds;

  }

  public static void main(String[] args) {

    Song FIS = new Song("Feel It Still", "Portugal. The Man", "pop", "2", "44");
    Song LYLT = new Song("Love You Long Time", "Pentatonix", "acapella", "3", "06");
    Song SM = new Song("Sunday Morning", "The October Project", "pop", "4", "42");

    System.out.println("These are songs that the Middlebury Mamajamas perform.");
    System.out
        .println(FIS.name + ", by " + FIS.artist + ", is a " + FIS.genre + " song. It is " + FIS.length + " long.");

    System.out
        .println(LYLT.name + ", by " + LYLT.artist + ", is a " + LYLT.genre + " song. It is " + LYLT.length + " long.");

    System.out.println(SM.name + ", by " + SM.artist + ", is a " + SM.genre + " song. It is " + SM.length + " long.");

  }
}