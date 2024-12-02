package Classe;

import java.util.ArrayList;

public class GerenciadorDeTarefas {
    private ArrayList<Tarefa> tarefas;

    public GerenciadorDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    public boolean marcarTarefaConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).marcarConcluida();
            return true;
        }
        return false;
    }

    public boolean removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            return true;
        }
        return false;
    }

    public String listarTarefas() {
        if (tarefas.isEmpty()) {
            return "Nenhuma tarefa cadastrada.";
        }

        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            lista.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return lista.toString();
    }

    public boolean isListaVazia() {
        return tarefas.isEmpty();
    }
}

