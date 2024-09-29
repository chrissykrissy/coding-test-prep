package coding.프로그래머스.고득점kit.해시;

import java.util.*;

public class 베스트앨범 {
    class Genre implements Comparable<Genre>{
        private int total = 0;
        private Queue<Music> q = new PriorityQueue<>();

        public int getTotal() {
            return total;
        }

        public Queue<Music> getQ() {
            return q;
        }

        public void addMusic(Music music){
            this.q.add(music);
            this.total += music.plays;
        }

        @Override
        public int compareTo(Genre o) {
            return o.getTotal() - this.getTotal();
        }
    }

    class Music implements Comparable<Music> {
        private final int id;
        private final int plays;

        public Music(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        public int getId() {
            return id;
        }

        public int getPlays() {
            return plays;
        }

        @Override
        public int compareTo(Music o) {
            int r = o.plays - this.plays;
            if(r == 0) r = this.id - o.id;
            return r;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();

        ArrayList<Genre> list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(i, plays[i]);
            map.putIfAbsent(genres[i], new Genre());
            map.get(genres[i]).addMusic(music);
        }

        for(String k : map.keySet()){
            list.add(map.get(k));
        }

        Collections.sort(list);

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(Genre genre : list){
            int cnt = 0;
            while(!genre.getQ().isEmpty()){
                if(cnt >= 2) break;
                answer.add(genre.getQ().poll().getId());
                cnt++;
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
