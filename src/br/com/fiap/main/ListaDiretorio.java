package br.com.fiap.main;

import javax.swing.*;
import java.io.File;

public class ListaDiretorio {
    public static void main(String[] args) {
        do {
            try {
                String path = JOptionPane.showInputDialog("Digite o caminho da pasta ( utilize / entre as pastas");
                File dir = new File(path);
                if (dir.isDirectory()){
                    System.out.println("Conteudo da pasta: " + path);  // (is.Directory) seria um diretorio?
                    String [] lista = dir.list(); // comando para criar lista
                    if (lista != null) {
                        for (String item : lista) {
                            System.out.println(item);
                        }
                    }
                } else{
                    System.out.println("Caminho irfomado incorreto!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atrnção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
    }
}
