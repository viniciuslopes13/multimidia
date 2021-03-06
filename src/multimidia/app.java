package multimidia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class app {

    public static void main(String[] args) throws IOException {
    	 
        try {
            //carrega nova imagem
            BufferedImage imagem1 = ImageIO.read(new File("image\\imagem1.png"));
            //instancia um filtro e aplica a escala de cinza
            Filtro filtro = new Filtro();
            filtro.threshold(imagem1, 200);
            //gera uma nova imagem a partir da imagem1
            ImageIO.write(imagem1,"png",new File("image\\imagem2flip.png"));
 
            //aqui apenas para demonstração,
            //carreguei novamente as duas imagens para exibi-las dentro de um JFrame
            imagem1 = ImageIO.read(new File("image\\imagem1.png"));
            BufferedImage imagem2 = ImageIO.read(new File("image\\imagem2flip.png"));
            Exibicao show = new Exibicao();
            show.exibirImagem(imagem1, imagem2);
            System.out.println("Filtro aplicado com sucesso!");
        }
        catch(IOException e){
            System.out.println("Erro! Verifique se o arquivo especificado existe e tente novamente.");
        }
        catch(Exception e){
            System.out.println("Erro! " + e.getMessage());
        }
    }
	
}
