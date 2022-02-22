package week2;

public class Song {
  // have at least five instance variables on your class.

  private String name;
  private String artist;
  private String genre;
  private int minutes;
  private int seconds;
  private String length;

  public Song(String name, String artist, String genre, int minutes, int seconds) {
    this.name = name;
    this.artist = artist;
    this.genre = genre;
    this.minutes = minutes;
    this.seconds = seconds;

    this.length = minutes + ":" + seconds;
  }

  public static void main(String[] args) {

    Song Case = new Song("A Case Of You", "Joni Mitchell", "folk", 4, 24);

    System.out
        .println(Case.name + ", by " + Case.artist + ", is a " + Case.genre + " song. It is " + Case.length + " long.");

  }
}