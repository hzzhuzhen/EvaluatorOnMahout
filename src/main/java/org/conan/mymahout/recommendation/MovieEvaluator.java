package org.conan.mymahout.recommendation;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.conan.mymahout.recommendation.book.RecommendFactory;

public class MovieEvaluator {

    final static int NEIGHBORHOOD_NUM = 2;
    final static double NEIGHBORHOOD_THRESHOLD = 0.5;//＜0.5
    final static int RECOMMENDER_NUM = 3;//NEIGHBORHOOD_NUM


	/**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userEuclidean(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclidean");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userLoglikelihood(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userLoglikelihood");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }   
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userCosine(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userCosine");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：User-based CF; 
  	 * 近邻算法：K-NEAREST;
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):1
  	 */
    public static RecommenderBuilder userPearson(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userPearson");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
	/**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userEuclideanNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclideanNoPref");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }   
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userLoglikelihoodNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userLoglikelihoodNoPref");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }    
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：K-NEAREST;
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userCosineNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userCosineNoPref");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：User-based CF; 
  	 * 近邻算法：K-NEAREST;
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):2
  	 */
    public static RecommenderBuilder userPearsonNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userPearsonNoPref");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.NEAREST, userSimilarity, dataModel, NEIGHBORHOOD_NUM);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    
   
    //-----------------------------Threshold
    
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userEuclideanThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclideanThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userLoglikelihoodThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userLoglikelihoodThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }   
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder userCosineThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userCosineThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：User-based CF; 
  	 * 近邻算法：THRESHOLD;
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):1
  	 */
    public static RecommenderBuilder userPearsonThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userPearsonThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, true);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
	/**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userEuclideanNoPrefThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userEuclideanNoPrefThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }   
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userLoglikelihoodNoPrefThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userLoglikelihoodNoPrefThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }    
    /**
	 * 协同过滤方法：User-based CF; 
	 * 近邻算法：THRESHOLD;
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder userCosineNoPrefThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userCosineNoPrefThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel, NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：User-based CF; 
  	 * 近邻算法：THRESHOLD;
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):2
  	 */
    public static RecommenderBuilder userPearsonNoPrefThreshold(DataModel dataModel) throws TasteException, IOException {
        System.out.println("userPearsonNoPrefThreshold");
        UserSimilarity userSimilarity = RecommendFactory.userSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        UserNeighborhood userNeighborhood = RecommendFactory.userNeighborhood(RecommendFactory.NEIGHBORHOOD.THRESHOLD, userSimilarity, dataModel,NEIGHBORHOOD_THRESHOLD);
        RecommenderBuilder recommenderBuilder = RecommendFactory.userRecommender(userSimilarity, userNeighborhood, false);
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    
    //--------------------------Item based
     
    
	/**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder itemEuclidean(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemEuclidean");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
	/**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder itemLoglikelihood(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemLoglikelihood");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):1
	 */
    public static RecommenderBuilder itemCosine(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemCosine");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, true);
        
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：Item-based CF; 
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):1
  	 */
    public static RecommenderBuilder itemPearson(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemPearson");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, true);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    
	/**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Euclidean
	 * 基于评分值(1)还是基于boolean(2):2
	 */   
    public static RecommenderBuilder itemEuclideanNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemEuclideanNoPref");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.EUCLIDEAN, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
	/**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Loglikelihood
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder itemLoglikelihoodNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemLoglikelihoodNoPref");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.LOGLIKELIHOOD, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
	 * 协同过滤方法：Item-based CF; 
	 * 相似度算法：Cosine
	 * 基于评分值(1)还是基于boolean(2):2
	 */
    public static RecommenderBuilder itemCosineNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemCosineNoPref");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.COSINE, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, false);
        
        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    /**
  	 * 协同过滤方法：Item-based CF; 
  	 * 相似度算法：Pearson
  	 * 基于评分值(1)还是基于boolean(2):2
  	 */
    public static RecommenderBuilder itemPearsonNoPref(DataModel dataModel) throws TasteException, IOException {
        System.out.println("itemPearsonNoPref");
        ItemSimilarity itemSimilarity = RecommendFactory.itemSimilarity(RecommendFactory.SIMILARITY.PEARSON, dataModel);
        RecommenderBuilder recommenderBuilder = RecommendFactory.itemRecommender(itemSimilarity, false);

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }
    
    
    //-----slopOne
    public static RecommenderBuilder slopeOne(DataModel dataModel) throws TasteException, IOException {
        System.out.println("slopeOne");
        RecommenderBuilder recommenderBuilder = RecommendFactory.slopeOneRecommender();

        RecommendFactory.evaluate(RecommendFactory.EVALUATOR.AVERAGE_ABSOLUTE_DIFFERENCE, recommenderBuilder, null, dataModel, 0.7);
        RecommendFactory.statsEvaluator(recommenderBuilder, null, dataModel, 5);
        return recommenderBuilder;
    }

    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws TasteException, IOException {
        String file = "datafile/ml-100k/u1_base"+".csv";
        DataModel dataModel = RecommendFactory.buildDataModel(file);
        
/*      userEuclidean(dataModel);
        userLoglikelihood(dataModel);
        userEuclideanNoPref(dataModel);
        userCosine(dataModel);
        
        itemEuclidean(dataModel);
        itemLoglikelihood(dataModel);
        itemEuclideanNoPref(dataModel);
        slopeOne(dataModel);*/
        
        //一组基于用户的测试
/*      userEuclidean(dataModel);
        userLoglikelihood(dataModel);
        userCosine(dataModel);
        userPearson(dataModel);
        
        userEuclideanNoPref(dataModel);
        userLoglikelihoodNoPref(dataModel);
        userCosineNoPref(dataModel);
        userPearsonNoPref(dataModel);*/
        
        //threshold
        
  /*      userEuclideanThreshold(dataModel);
        userLoglikelihoodThreshold(dataModel);
        userCosineThreshold(dataModel);
        userPearsonThreshold(dataModel);
        
        userEuclideanNoPrefThreshold(dataModel);
        userLoglikelihoodNoPrefThreshold(dataModel);
        userCosineNoPrefThreshold(dataModel);
        userPearsonNoPrefThreshold(dataModel);*/
        
        //item based
        itemEuclidean(dataModel);
        itemLoglikelihood(dataModel);
        itemCosine(dataModel);
        itemPearson(dataModel);
        
        itemEuclideanNoPref(dataModel);
        itemLoglikelihoodNoPref(dataModel);
        itemCosineNoPref(dataModel);
        itemPearsonNoPref(dataModel);
        
        
        //slope
        slopeOne(dataModel);
        
    }
    
    
    
    
    
}
