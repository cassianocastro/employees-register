package view;

import javax.swing.*;

/**
 *
 * @author User
 */
public class FuncionarioView implements View{
    
    @Override
    public int getOption(){
        return JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção:", "Funcionário",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new String[] {"Inserir", "Exibir", "Procurar", "Atualizar", "Remover", "Sair"},
            null
        );
    }
    
    @Override
    public String[] insert(){
        Cadastro cadastro = new Cadastro();

        return cadastro.getDados();
    }
    
    @Override
    public void show(CharSequence mensagem){
        JOptionPane.showMessageDialog(
            null,
            mensagem,
            "Funcionários",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    @Override
    public String getID(){
        return JOptionPane.showInputDialog("Informe o ID:");
    }
    
    @Override
    public String[] update(){
        String atributo = JOptionPane.showInputDialog(
            null,
            "Tipo de Atributo:", "Alterar...",
            JOptionPane.DEFAULT_OPTION,
            null,
            new String[] {"Nome", "CPF", "Sexo", "Data de Nascimento"},
            null
        ).toString();
        String novoDado = JOptionPane.showInputDialog(null, atributo + ":");
        return new String[] {
            atributo,
            novoDado
        };
    }

}
