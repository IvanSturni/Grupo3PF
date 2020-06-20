package grupo3pf;

import java.time.*;
import entidades.*;
import modelos.*;
import java.util.*;

public class Grupo3PF {

    //static enum DiaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
    private static final Conexion con = new Conexion();
    private static final AfiliadoData ad = new AfiliadoData();
    private static final HorarioData hd = new HorarioData();
    private static final PrestadorData pd = new PrestadorData();
    private static final OrdenData od = new OrdenData();
    private static final EspecialidadData ed = new EspecialidadData();

    public static void main(String[] args) {
        crearDatosPrueba();
    }

    private static void crearDatosPrueba() {
        
        Afiliado a1 = ad.altaAfiliado(new Afiliado(41293222, "Jose", true));
        Afiliado a2 = ad.altaAfiliado(new Afiliado(57134993, "Cristina", true));
        Afiliado a3 = ad.altaAfiliado(new Afiliado(36542388, "Raul", true));
        Afiliado a4 = ad.altaAfiliado(new Afiliado(19334367, "María", true));
        Afiliado a5 = ad.altaAfiliado(new Afiliado(41662673, "Pedro", true));
        Afiliado a6 = ad.altaAfiliado(new Afiliado(36112589, "Roberto", true));
        Afiliado a7 = ad.altaAfiliado(new Afiliado(12446553, "Patricia", true));
        Afiliado a8 = ad.altaAfiliado(new Afiliado(52334677, "Adolfo", true));
        Afiliado a9 = ad.altaAfiliado(new Afiliado(34555656, "Monica", true));
        
        Especialidad e1 = ed.altaEspecialidad(new Especialidad("Gastroenterología"));
        Especialidad e2 = ed.altaEspecialidad(new Especialidad("Endocrinología"));
        Especialidad e3 = ed.altaEspecialidad(new Especialidad("Cardiología"));
        Especialidad e4 = ed.altaEspecialidad(new Especialidad("Neurología"));
        Especialidad e5 = ed.altaEspecialidad(new Especialidad("Dermatología"));
        Especialidad e6 = ed.altaEspecialidad(new Especialidad("Ginecología"));
        Especialidad e7 = ed.altaEspecialidad(new Especialidad("Pediatría"));
        Especialidad e8 = ed.altaEspecialidad(new Especialidad("Neumonología"));
        Especialidad e9 = ed.altaEspecialidad(new Especialidad("Oftalmología"));
        
        Prestador p1 = pd.altaPrestador(new Prestador(38162736, "Dr. Perez", e1, true));
        Prestador p2 = pd.altaPrestador(new Prestador(16234998, "Dr. Saez", e2, true));
        Prestador p3 = pd.altaPrestador(new Prestador(24163444, "Dra. Fernandez", e3, true));
        Prestador p4 = pd.altaPrestador(new Prestador(33647122, "Dra. Dominguez", e2, true));
        Prestador p5 = pd.altaPrestador(new Prestador(36885362, "Dr. Rodriguez", e5, true));
        Prestador p6 = pd.altaPrestador(new Prestador(12356334, "Dr. Paz", e7, true));
        Prestador p7 = pd.altaPrestador(new Prestador(11123424, "Dra. Torres", e7, true));
        Prestador p8 = pd.altaPrestador(new Prestador(26135234, "Dr. Godoy", e5, true));
        Prestador p9 = pd.altaPrestador(new Prestador(23555455, "Dra. Castillo", e9, true));
        
        Horario h1 = hd.altaHorario(new Horario(p1, DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(13, 0)));
        Horario h2 = hd.altaHorario(new Horario(p1, DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(18, 30)));
        Horario h3 = hd.altaHorario(new Horario(p2, DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(12, 0)));
        Horario h4 = hd.altaHorario(new Horario(p2, DayOfWeek.WEDNESDAY, LocalTime.of(16, 00), LocalTime.of(18, 00)));
        Horario h5 = hd.altaHorario(new Horario(p3, DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(21, 00)));
        Horario h6 = hd.altaHorario(new Horario(p5, DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(12, 00)));
        Horario h7 = hd.altaHorario(new Horario(p5, DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(12, 00)));
        Horario h8 = hd.altaHorario(new Horario(p5, DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(12, 00)));
        Horario h9 = hd.altaHorario(new Horario(p9, DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(18, 00)));
        
        Orden o1 = od.altaOrden(new Orden(a1,h1,LocalDate.of(2020, Month.MARCH, 3), LocalDate.of(2020, Month.MARCH, 1),true,false));
        Orden o2 = od.altaOrden(new Orden(a2,h1,LocalDate.of(2020, Month.MARCH, 4), LocalDate.of(2020, Month.MARCH, 3),true,true));
        Orden o3 = od.altaOrden(new Orden(a3,h1,LocalDate.of(2020, Month.MARCH, 20), LocalDate.of(2020, Month.MARCH, 17),false,true));
        Orden o4 = od.altaOrden(new Orden(a4,h1,LocalDate.of(2020, Month.JULY, 3), LocalDate.of(2020, Month.JULY, 2),true,false));
        Orden o5 = od.altaOrden(new Orden(a5,h3,LocalDate.of(2020, Month.AUGUST, 18), LocalDate.of(2020, Month.AUGUST, 5),true,true));
        Orden o6 = od.altaOrden(new Orden(a6,h3,LocalDate.of(2020, Month.AUGUST, 18), LocalDate.of(2020, Month.AUGUST, 6),false,true));
        Orden o7 = od.altaOrden(new Orden(a7,h4,LocalDate.of(2020, Month.DECEMBER, 12), LocalDate.of(2020, Month.DECEMBER, 5),false,true));
        Orden o8 = od.altaOrden(new Orden(a8,h5,LocalDate.of(2020, Month.MAY, 2), LocalDate.of(2020, Month.MAY, 2),true,true));
        Orden o9 = od.altaOrden(new Orden(a9,h6,LocalDate.of(2020, Month.APRIL, 22), LocalDate.of(2020, Month.APRIL, 22),true,false));
    }

}
