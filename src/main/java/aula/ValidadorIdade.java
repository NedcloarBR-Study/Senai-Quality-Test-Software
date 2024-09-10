package aula;

public class ValidadorIdade {
  public boolean eMaiorIdade(int idade){
    if(idade >= 18){
      return true;
    } 
    return false;
  }
  
  public void eMenorIdade(int idade) throws Exception {
    if(idade >= 18){
      throw new Exception("Error: Maior de idade");
    }
  }
}
