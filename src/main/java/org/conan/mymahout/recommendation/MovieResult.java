package org.conan.mymahout.recommendation;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.conan.mymahout.recommendation.book.RecommendFactory;

public class MovieResult {

    final static int NEIGHBORHOOD_NUM = 2;
    final static int RECOMMENDER_NUM = 3;

    public static void main(String[] args) throws TasteException, IOException {
        String file = "datafile/ml-100k/u1_base"+".csv";;
        DataModel dataModel = RecommendFactory.buildDataModel(file);
        RecommenderBuilder rb1 = MovieEvaluator.userEuclidean(dataModel);
        RecommenderBuilder rb2 = MovieEvaluator.itemEuclidean(dataModel);
        RecommenderBuilder rb3 = MovieEvaluator.userEuclideanNoPref(dataModel);
        RecommenderBuilder rb4 = MovieEvaluator.itemEuclideanNoPref(dataModel);
        
        LongPrimitiveIterator iter = dataModel.getUserIDs();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            System.out.print("userEuclidean       =>");
            result(uid, rb1, dataModel);
            System.out.print("itemEuclidean       =>");
            result(uid, rb2, dataModel);
            System.out.print("userEuclideanNoPref =>");
            result(uid, rb3, dataModel);
            System.out.print("itemEuclideanNoPref =>");
            result(uid, rb4, dataModel);
        }
    }

    public static void result(long uid, RecommenderBuilder recommenderBuilder, DataModel dataModel) throws TasteException {
        List<RecommendedItem> list = recommenderBuilder.buildRecommender(dataModel).recommend(uid, RECOMMENDER_NUM);
        RecommendFactory.showItems(uid, list, false);
    }

}
