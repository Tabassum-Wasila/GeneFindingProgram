
public class FindGene
{
    
    public String findGeneSimple(String dna)
    {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1)
        {
            return result;
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        while(stopIndex != -1)
        {
            if( (stopIndex - startIndex) % 3 == 0)
            {
                result = dna.substring(startIndex, stopIndex + 3);
                break;
            }
            else
            {
                stopIndex = dna.indexOf("TAA", stopIndex + 1);
            }
        }
        return result;
    }
    public void testGene()
    {
        //No start codon
        String dna = "ATTCAGTGCTAATGC";
        String gene = findGeneSimple(dna);
        System.out.println("\nDNA Strand: " + dna + "\nGene: " + gene);
        
        //No stop codon
        dna = "ATGCAGTGCTACTGC";
        gene = findGeneSimple(dna);
        System.out.println("\nDNA Strand: " + dna + "\nGene: " + gene);
        
        //Distance between start and stop codon is not divisible by 3
        dna = "ATGCAGTGCTTAATGC";
        gene = findGeneSimple(dna);
        System.out.println("\nDNA Strand: " + dna + "\nGene: " + gene);
        
        //Distance between start and stop codon is divisible by 3
        dna = "ATGCAGTGCTAATCG";
        gene = findGeneSimple(dna);
        System.out.println("\nDNA Strand: " + dna + "\nGene: " + gene);
        
        //One start codon and two stop codons
        dna = "ATGCAGTGCTAATAA";
        gene = findGeneSimple(dna);
        System.out.println("\nDNA Strand: " + dna + "\nGene: " + gene);
    }
}
