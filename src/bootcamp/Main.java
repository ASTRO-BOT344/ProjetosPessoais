import java.time.LocalDate;
import java.util.*;


abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}


class Curso extends Conteudo {
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    @Override
    public String toString() {
        return "Curso: " + getTitulo() + " (" + cargaHoraria + "h)";
    }
}


class Mentoria extends Conteudo {
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    @Override
    public String toString() {
        return "Mentoria: " + getTitulo() + " em " + data;
    }
}

// 
class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Conteudo> getConteudos() { return conteudos; }
    public Set<Dev> getDevsInscritos() { return devsInscritos; }
}


class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Ops! Você não possui conteúdos pendentes.");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Conteudo> getConteudosInscritos() { return conteudosInscritos; }
    public Set<Conteudo> getConteudosConcluidos() { return conteudosConcluidos; }
}


public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java POO");
        cursoJava.setDescricao("Aprenda os pilares da OO");
        cursoJava.setCargaHoraria(8);

        Mentoria mentoriaDuvidas = new Mentoria();
        mentoriaDuvidas.setTitulo("Mentoria de Java");
        mentoriaDuvidas.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp VisionTech");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(mentoriaDuvidas);

        Dev devFulano = new Dev();
        devFulano.setNome("Fulano de Tal");
        devFulano.inscreverBootcamp(bootcamp);

        System.out.println("Inscritos Fulano: " + devFulano.getConteudosInscritos());
        devFulano.progredir();
        System.out.println("Concluídos Fulano: " + devFulano.getConteudosConcluidos());
        System.out.println("XP Total: " + devFulano.calcularTotalXp());
    }
}