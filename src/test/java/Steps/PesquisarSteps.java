package Steps;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.*;

public class PesquisarSteps {
	WebDriver driver = new ChromeDriver();

	@Given("que estou no site google")
	public void que_estou_no_site_google() {
		driver.get("https://www.google.com.br/");
	}

	@When("digito a palavra nttdata")
	public void digito_a_palavra_nttdata() {
		WebElement campoPesquisar = driver.findElement(By.xpath("//textarea[@aria-label='Pesquisar']"));
		campoPesquisar.sendKeys("nttdata");
	}

	@And("clico em pesquisar")
	public void clico_em_pesquisar() {
		WebElement campoPesquisar = driver.findElement(By.xpath("//textarea[@aria-label='Pesquisar']"));
		campoPesquisar.sendKeys(Keys.ENTER);
	}

	@Then("posso acessar o primeiro link apresentado na pesquisa")
	public void posso_acessar_o_primeiro_link_apresentado_na_pesquisa() {
		WebElement linkElement = driver.findElement(By.xpath("//a[@href='https://nttdata-solutions.com/br/']"));
		linkElement.click();
	}

	@Given("que estou no site da ntt")
	public void que_estou_no_site_da_ntt() {
		driver.get(
			"https://nttdata-solutions.com/br/?utm_term=ntt%20data&utm_campaign=NOVO%20-%20%5BP%5D%20Branding&utm_source=adwords&utm_medium=ppc&hsa_acc=6608866874&hsa_cam=12627448046&hsa_grp=119455732985&hsa_ad=509959537851&hsa_src=g&hsa_tgt=kwd-320773906274&hsa_kw=ntt%20data&hsa_mt=p&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAjw9pGjBhB-EiwAa5jl3NUbJDugH_U5be1Wlaj8R-DTRv-yaqTDr-PE4taResHejcC0HbEomxoCxIEQAvD_BwE");
	}

	@Given("clico em carreira")
	public void clico_em_carreira() throws InterruptedException {
		WebElement elementoCarreira = driver.findElement(By.xpath("//li[@id='menu-item-32094']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementoCarreira).click().perform();

	}

	@When("acesso junte-se a nossa equipe")
	public void acesso_junte_se_a_nossa_equipe() throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//a[@href='https://platform.senior.com.br/hcmrs/hcm/curriculo/?tenant=fhcombr&tenantdomain=fh.com.br#!/vacancies/list']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('cookiebanner').remove();");
	    link.click();
	    Set<String> janelas = driver.getWindowHandles();

	    for (String janela : janelas) {
	        driver.switchTo().window(janela);
	        if (!driver.getTitle().equals("Carreiras e Oportunidades de Trabalho em SAP")) {
	            break;
			}
		}
	}

	@Then("na lista de vagas posso  pesquisar a vaga de arquiteto")
	public void na_lista_de_vagas_posso_pesquisar_a_vaga_de_arquiteto() throws InterruptedException {
		
		String janelaPrincipal = driver.getWindowHandle();
		Set<String> janelas = driver.getWindowHandles();
		for (String janela : janelas) {
		    if (!janela.equals(janelaPrincipal)) {
		        driver.switchTo().window(janela);
		        break;
		    }
		}
		driver.switchTo().frame(0);
		 Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id=\"pesquisar-vaga-localidade-etc\"]")).sendKeys("Arquiteto");

	}

}
