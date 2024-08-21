package br.com.fiap.main;

import javax.swing.*;
import java.io.File;

public class ExcluirDiretorio {
    public static void main(String[] args) {
        try {
            File dir = new File("d:/loja");
            String msg = "";
            if (dir.isDirectory()) {
                int escolha = JOptionPane.showConfirmDialog(null, "Deseja excluir o diretório " + dir.getName() + "?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (escolha == 0) {
                    if (dir.delete()) {
                        msg = dir.getName() + " excluído com sucesso!";
                        JOptionPane.showMessageDialog(null, msg);
                    } else {
                        if (excluirFilhos(dir)) {
                            msg = dir.getName() + " excluído com sucesso!";
                            JOptionPane.showMessageDialog(null, msg);
                        } else {
                            msg = "Falha! " + dir.getName() + " não foi excluído!";
                            JOptionPane.showMessageDialog(null, msg);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean excluirFilhos(File dir) {
        if (dir.isDirectory()) {
            String[] conteudo = dir.list();
            for (String item : conteudo) {
                boolean sucesso = excluirFilhos(new File(dir, item));
                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Arquivo " + item + " excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Arquivo " + item + " não foi excluído!");
                    return false;
                }
            }

        } return dir.delete();
    }
}