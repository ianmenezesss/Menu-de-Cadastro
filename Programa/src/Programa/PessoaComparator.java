package Programa;

import java.util.Comparator;

//Classe PessoaComparator para comparar pessoas pelo nome (utilizado na ordenação)

public class PessoaComparator implements Comparator<Pessoa> {
    @Override
    public int compare(Pessoa pessoa1, Pessoa pessoa2) {
        return pessoa1.getNome().compareToIgnoreCase(pessoa2.getNome());
    }
}
