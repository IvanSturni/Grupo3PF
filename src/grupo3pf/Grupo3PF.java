package grupo3pf;

import java.time.*;

public class Grupo3PF {

    static enum DiaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
    
    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2000, Month.MARCH, 15);
        LocalTime lt = LocalTime.of(20, 20); // horas para los horarios
        
        LocalTime lll = LocalTime.now();
        DiaSemana dt = DiaSemana.JUEVES;
        DayOfWeek dj = DayOfWeek.of(4);  // 1 = lunes, 7 = domingo
        System.out.println(dj); // THURSDAY
        System.out.println(dt); // JUEVES
    }
    
}
