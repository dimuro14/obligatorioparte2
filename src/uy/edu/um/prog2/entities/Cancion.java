package uy.edu.um.prog2.entities;

public class Cancion {

    private String spotify_id;
    private String name;
    private String artists;
    private int daily_rank;
    private int daily_movement;
    private int weekly_movement;
    private String country;
    private String snapshot_date;
    private int popularity;
    private boolean is_explicit;
    private int duration_ms;
    private String album_name;
    private String album_release_date;
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int time_signature;

    public Cancion(String spotify_id,
                   String name,
                   String artists,
                   int daily_rank,
                   int daily_movement,
                   int weekly_movement,
                   String country,
                   String snapshot_date,
                   int popularity,
                   boolean is_explicit,
                   int duration_ms,
                   String album_name,
                   String album_release_date,
                   double danceability,
                   double energy,
                   int key,
                   double loudness,
                   int mode,
                   double speechiness,
                   double acousticness,
                   double instrumentalness,
                   double liveness,
                   double valence,
                   double tempo,
                   int time_signature
        ) {

        this.spotify_id = spotify_id;
        this.name = name;
        this.artists = artists;
        this.daily_rank = daily_rank;
        this.daily_movement = daily_movement;
        this.weekly_movement = weekly_movement;
        this.country = country;
        this.snapshot_date = snapshot_date;
        this.popularity = popularity;
        this.is_explicit = is_explicit;
        this.duration_ms = duration_ms;
        this.album_name = album_name;
        this.album_release_date = album_release_date;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.time_signature = time_signature;

    }

    public String getNombre() {

        return this.name;

    }

    public String[] getArtistas() {

        String[] nombresArtistas = this.artists.split(",");

        for (int i = 0; i < nombresArtistas.length; i++) {

            nombresArtistas[i] = nombresArtistas[i].trim();

        }

        return nombresArtistas;

    }

    public String getPais() {

        return this.country;

    }

    public double getTempo() {

        return this.tempo;

    }

}
