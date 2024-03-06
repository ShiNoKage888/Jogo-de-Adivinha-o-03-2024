import java.util.Random;

import javax.swing.JOptionPane;

public class Jogo {
    public Jogo() throws Exception{
        String nome = JOptionPane.showInputDialog("Insira seu nome:");
        if (nome.equals("")){
            throw new Exception("O jogador tem que ter um nome!!");
        }
        
        String escolha = JOptionPane.showInputDialog("Olá, "+nome+", você quer jogar um jogo? (s/n)");
        if (escolha.equals("s") || escolha.equals("n")) {
            JOptionPane.showMessageDialog
            (null, "Esse é um jogo de adivinhação. Você tem três chances de adivinhar o número sorteado. A cada vitória o limite de números que podem ser sorteados aumenta. Boa sorte!!!");
        } else {
            throw new Exception("Você digitou uma opção inválida!!");
        }

        int chances = 2;
        int dicas = 2;
        Random rand = new Random();

        int vitorias = 0;
        int limite = 10;
        int pontuacao = 0;

        

        while  (escolha.equals("s")) {
            if (vitorias != 0){
                limite += vitorias*10;
            }

            int num = rand.nextInt(limite);
            
            while (chances > -1) {
                int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Esse é um jogo de Adivinhação\nEscolha um numero entre 0 a "+limite+"\n"+num));
                
                if (x == num) {
                    vitorias++;
                    JOptionPane.showMessageDialog(null, "Parabéns, "+nome+" você ganhou!!!\nEssa é sua "+vitorias+"ª de hoje!!!");
                    pontuacao += 10 * (chances+1) + 10 * (dicas);
                    JOptionPane.showMessageDialog(null, "Sua atual pontuação é: "+pontuacao);
                    chances = -1;
                } else if (chances != 0){
                    JOptionPane.showMessageDialog(null, "Errou, você tem mais "+chances+" chances!!!");
                    String y = JOptionPane.showInputDialog(null, "Você deseja uma dica? (s/n)\n*Isso diminuirá sua pontuação*");
                    if(y.equals("s")){
                        if (num > x) {
                            JOptionPane.showMessageDialog(null, "O número sorteado é maior que: "+x);
                        } else {
                            JOptionPane.showMessageDialog(null, "O número é menor que: "+x);
                        }
                        dicas--;
                    }
                    chances--;
                } else if (chances == 0){
                    JOptionPane.showMessageDialog(null, nome+", você não tem mais chances. Você perdeu!!!");
                    chances--;
                }
            }
            escolha = JOptionPane.showInputDialog(nome+", você quer jogar novamente? (s/n)");
            if (escolha.equals("s")) {
                chances = 2;
            }
        }
        JOptionPane.showMessageDialog(null, "Entendo, até a próxima "+nome+". Boa noite!");
        JOptionPane.showMessageDialog(null, "Você teve "+vitorias+" hoje\nSua pontuação final é: "+pontuacao);
    }

}
