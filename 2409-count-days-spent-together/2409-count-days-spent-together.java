import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate alicea=LocalDate.parse("2026-"+arriveAlice);
        LocalDate aliceb=LocalDate.parse("2026-"+leaveAlice);
        LocalDate boba=LocalDate.parse("2026-"+arriveBob);
        LocalDate bobb=LocalDate.parse("2026-"+leaveBob);

        LocalDate start=alicea.isAfter(boba)?alicea:boba;
        LocalDate end=aliceb.isBefore(bobb)?aliceb:bobb;

        if(start.isAfter(end))return 0;

        return (int)ChronoUnit.DAYS.between(start,end)+1;
        
    }
}