package com.raven.form;

import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BlogArticle extends javax.swing.JPanel {

    public BlogArticle() {
        initComponents();
       
        setOpaque(false);
        initData();
    }

    private void initData() {
        initCardData();
        initNoticeBoard();
        initTableData();
    }

    private void initTableData() {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Delete Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Update Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };
       }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
       // card1.setData(new ModelCard("BLOG ARTICLE", 2, 20, icon1));
           }

    private void initNoticeBoard() {
        //noticeBoard.addDate("03/10/2022");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Are There Good Reasons for Being a Farmer?", "12:30 PM", "Farming was among the earliest of civilized man’s occupations, and it has been the main economic basis of every civilization down to fairly recent times. Among ancient peoples, the landowner was regarded, along with the warrior, as the most respected and honored of men.\n" +
"\n" +
"Our own American civilization is grounded on the ideals of a simple agricultural society. Many of the Fathers of our country, such as Washington and Jefferson, were farmers and their outlook on life largely shaped the spirit of our Constitution and government.\n" +
"\n" +
"Perhaps the first question which anyone who considers taking up farming as a career asks himself is: Do I like farming as a way of life?\n" +
"\n" +
"According to its devotees, farming offers satisfactions not often found in other tasks. Secretary of Agriculture Claude R. Wickard, himself a farmer, told a meeting of the Future Farmers of America on October 10, 1944: “I like farming. It is a good life. After more than 30 years of it, I still would rather farm than do anything else. I envy you future farmers who have such great things ahead.”\n" +
"\n" +
"About ten years ago, Dr. O. E. Baker, a long-time student of agriculture, addressed a rural youth conference at the University of Illinois on the advantages of farm life. Dr. Baker-who may be regarded as a spokesman for the school of farming enthusiasts -said, “I have a son now less than 5 years old, and I hope when he grows up that he will decide to be a farmer.” Dr. Baker’s reasons for wanting his son to be a farmer were:\n" +
"\n" +
"A farmer has more and better food to eat than have most people who live in cities.\n" +
"He is healthier and lives longer.\n" +
"He is likely to enjoy his work more than most city people do.\n" +
"He is more likely to rear a family and thereby promote the future welfare of the nation.\n" +
"Let us examine briefly each of these points."));
        
        
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Do farmers eat better?", "", "As to the question of diet, Dr. Baker based his assertion on (1) a United States Department of Agriculture study, made in fairly prosperous times, of 2,400 farm families and (2) a study by the United States Bureau of Labor Statistics of 12,000 workingmen’s families in cities. The farm families, it was found, were getting much more protein, calcium, phosphorous, and iron than was necessary for good nutrition. The city families, on the other hand, were getting barely enough protein and not enough calcium, phosphorous, and iron.\n" +
"\n" +
"The farm folk ate much more meat, eggs, milk, and vegetables—which they often produced themselves—than did the city folk, who depended more on cereals. Of course, city families with large incomes get more adequate food than workingmen’s families, but many farm people, if they moved to town, would undoubtedly fall into the latter class.\n" +
"\n" +
"Of course, there are farm families who do not get a rich and varied diet, even in prosperous times like the present. In some agricultural areas there are farmers who have no gardens and keep no livestock. Some do not have enough cash income to buy adequate, wholesome food."));
        
          noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Do farmers enjoy their work more?", "", "Whether working in the fields, orchard, or garden or taking care of livestock, farming involves many kinds of tasks and skills. In addition, a farmer usually has to keep his equipment in good shape; do repair jobs around the house, barn, and sheds; clear out brush and cut fuel wood; possibly keep drainage ditches open or mend roads; and do a hundred and one odd jobs.\n" +
"\n" +
"Those who prefer work in the country to work in the city contrast these varied tasks with the monotonous job of the factory hand who performs the same operation at high speed, hour after hour and day after day; or with that of the white-collar worker, sitting at his desk all day long, often under artificial light and in a hot, stuffy room.\n" +
"\n" +
"Industrial life, say the farming enthusiasts, is a relatively new experience for man. The modern type of factory and the crowded and grimy industrial city have only been in existence for about a century. It is true that a large portion of our population-and that of other industrial countries-has become adapted to the speedy tempo and inflexible routine. Some even enjoy it, but many do not and would flee from the city if they could.\n" +
"\n" +
"It is true that nearly all of us feel deep kinship with nature—but the farmer lives with it. He is intimately connected with the cycle of life. Many envy him and long for a small plot of soil where they can at least plant and grow flowers and vegetables.\n" +
"\n" +
"There is, of course, the old saying, “The farmer’s day is never done.” The chores on a farm are many and the monetary rewards often limited. But many farmers do not think of their occupation solely in terms of cash.\n" +
"\n" +
"To till the earth, to plant seeds and watch them grow, to see the young shoots mature in the summer sun, and then to harvest the crop are, to many people, deep and rewarding pleasures. So is the intimate association with animals—cattle, horses or mules, chickens, pigs, or sheep—dumb creatures who serve man well but who must be cared for tenderly and patiently.\n" +
"\n" +
"These and other rewards of farming often compensate for a meager cash income, lack of household comforts, and constant worry about drought, frost, flood, or other unfavorable turns of the weather which may damage crops or ruin fields.\n" +
"\n" +
"Those who prefer the city to the country have their answers to these arguments. Factory and office work, they say, may be less healthy and more nerve racking than farming. Cities may be noisy and crowded compared with the quiet and serenity of country life. But an urban environment is more stimulating mentally. Its social life is richer. It offers more opportunities for entertainment-organized sports, movies, and in some of the larger cities, legitimate theaters, symphony orchestras, operas, ballets, lectures, museums, and the like.\n" +
"\n" +
"The city enthusiasts like to quote from Robert Browning: “Had I but plenty of money, money enough and to spare, The house for me, no doubt, were a house in the city-square; Ah, such a life, such a life, as one leads at the window there!\n" +
"\n" +
"“Something to see, by Bacchus, something to hear, at least! There, the whole day long, one’s life is a perfect feast.”"));
          
            noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Is family life better on the farm?", "", "Some sociologists say that the farmer tends to have a happier home life than the city man.\n" +
"\n" +
"As a rule, farming is a family enterprise. The husband, wife, and children divide the labor, each doing what his or her strength and ability permit. By such teamwork, the family is knit into a tight and harmonious unit.\n" +
"\n" +
"Because they work together as well as live together, farm families are generally more stable than urban families. This assertion is borne out by 1930 census figures which show that 19 per cent of family groups in cities were broken as against 14.7 per cent in villages and only 8.1 per cent on farms. According to the farming enthusiasts, family life and all it stands for seem to be more appreciated in rural than in urban communities, where people in normal times do not stay at home so much and outside distractions make the members of some families almost strangers to each other.\n" +
"\n" +
"In answer to this, the city enthusiasts say that some farmers have more children than they can suitably provide for, and that the reason farm families tend to be more stable than urban families is that they don’t know how to get away from each other."));
            
              noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Do farmers earn less than city folk?", "", "Those who prefer city life often use as a final and supposedly clinching argument the fact that farming ordinarily brings a relatively small income in cash.\n" +
"\n" +
"What farmers have earned in the past is no certain guide to the future, but it does throw some light on the matter. According to the farm census of 1940, more than half the nation’s 6 million farm families had gross incomes of less than $1,000. This figure includes both money derived from the sale of crops and the value of food produced on the farm for home use. One-third of the over 3 million farm families with less than $1,000 gross income had supplementary earnings, usually because one or more members worked off the farm part of the year. But two-thirds had no such extra income.\n" +
"\n" +
"Of course, farmers have been better off in the past four years than in the census year of 1940. Still, the high incomes commonly earned in other types of business are relatively rare in agriculture, except for the small percentage of farmers who work several hundred acres, keep large dairy or ranch herds, run huge fruit farms, and the like.\n" +
"\n" +
"Those who prefer country life answer this argument by saying that, though city people generally earn more than farmers, they have to spend more. The cost of living is higher in urban than in rural areas. Rent is more; food costs more; it is necessary to have more clothes; and miscellaneous expenses are unquestionably greater.\n" +
"\n" +
"But, ask the proponents of farming, is there as much solid satisfaction in such expenditure? Isn’t much of it devoted to “keeping up with the Joneses”?\n" +
"\n" +
"Some economists even assert that the average farmer accumulates more wealth in his lifetime than the average city resident and that hence the farmer’s real income is higher than the city man’s.\n" +
"\n" +
"Thus the arguments go back and forth, arguments which have doubtless been heard since cities first arose and the attractions of urban existence began to draw folk away from quiet, simple, country haunts."));
              
      //  noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Do farmers eat better?", "12:30 PM", ""));
        
        noticeBoard.scrollToTop();
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / BLOG ARTICLE");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("BLOG ARTICLE");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Article");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(noticeBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(59, 122, 87));

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("BLOG ARTICLE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(618, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    // End of variables declaration//GEN-END:variables
}
