package Principal;

import javax.swing.*;

import Classe.GerenciadorDeTarefas;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        boolean executando = true;

        while (executando) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Selecione uma opção:\n" +
                            "1. Adicionar tarefa\n" +
                            "2. Marcar como concluída\n" +
                            "3. Remover tarefa\n" +
                            "4. Exibir todas as tarefas\n" +
                            "5. Sair",
                    "Gerenciador de Tarefas", JOptionPane.PLAIN_MESSAGE);

            if (opcao == null) {
                continue; // Lida com o caso do usuário fechar a janela
            }

            switch (opcao) {
                case "1":
                    adicionarTarefa(gerenciador);
                    break;
                case "2":
                    marcarTarefaConcluida(gerenciador);
                    break;
                case "3":
                    removerTarefa(gerenciador);
                    break;
                case "4":
                    exibirTarefas(gerenciador);
                    break;
                case "5":
                    executando = false;
                    JOptionPane.showMessageDialog(null, "Programa encerrado.", "Gerenciador de Tarefas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void adicionarTarefa(GerenciadorDeTarefas gerenciador) {
        String descricao = JOptionPane.showInputDialog(null, "Digite a nova tarefa:", "Adicionar Tarefa", JOptionPane.PLAIN_MESSAGE);
        if (descricao != null && !descricao.trim().isEmpty()) {
            gerenciador.adicionarTarefa(descricao.trim());
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida. Nenhuma ação realizada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void marcarTarefaConcluida(GerenciadorDeTarefas gerenciador) {
        if (gerenciador.isListaVazia()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para concluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String lista = gerenciador.listarTarefas();
        String escolha = JOptionPane.showInputDialog(null, lista + "\nSelecione o número da tarefa para marcar como concluída:", "Marcar como Concluída", JOptionPane.PLAIN_MESSAGE);

        try {
            int indice = Integer.parseInt(escolha) - 1;
            if (gerenciador.marcarTarefaConcluida(indice)) {
                JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void removerTarefa(GerenciadorDeTarefas gerenciador) {
        if (gerenciador.isListaVazia()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String lista = gerenciador.listarTarefas();
        String escolha = JOptionPane.showInputDialog(null, lista + "\nSelecione o número da tarefa para remover:", "Remover Tarefa", JOptionPane.PLAIN_MESSAGE);

        try {
            int indice = Integer.parseInt(escolha) - 1;
            if (gerenciador.removerTarefa(indice)) {
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Índice inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void exibirTarefas(GerenciadorDeTarefas gerenciador) {
        String lista = gerenciador.listarTarefas();
        JOptionPane.showMessageDialog(null, lista, "Lista de Tarefas", JOptionPane.INFORMATION_MESSAGE);
    }
}
