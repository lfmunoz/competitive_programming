import org.apache.commons.math3.distribution.NormalDistribution;

public class Probability {



    // https://www.programcreek.com/java-api-examples/?api=org.apache.commons.math3.distribution.NormalDistribution

    // http://commons.apache.org/proper/commons-math/javadocs/api-3.4/org/apache/commons/math3/distribution/BinomialDistribution.html

    // http://commons.apache.org/proper/commons-math/userguide/distribution.html

    public static void main(String[] args) {
        final NormalDistribution dist1 = new NormalDistribution();

        dist1.sample();


        System.out.println("hellot");
    }
}
/*

https://www.cs.cmu.edu/~epxing/Class/10708-14/scribe_notes/scribe_note_lecture17.pdf
http://www.mit.edu/~9.520/spring10/Classes/class21_mcmc_2010.pdf

var xs = [0,1,2,3];
var ys = [0,2,4,6];

var function = Infer({method: 'MCMC', samples: 10000}, function() {

  var m = sample(Guassian({mu:0, sigma:2}))
  var b = sample(Guassian({mu:0, sigma:2}))

  var f = function(x) {return m*x + b}

  var signam = sample (Gamma({shape:1: scale:1}))

  map2(function(x,y) {
    factor(Guassian({mu: f(x), sigma: signma}).score(y);
  }, xs, ys)

})

var predict = function() {
  var f = sample(functions)
  return f(4)
}

 */