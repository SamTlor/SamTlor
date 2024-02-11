import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Simple_random {
    private static boolean check(String[] arr, String toCheckValue){
        for(String three_nums : arr){
            if (toCheckValue.equals(three_nums)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rand_num_table = "1396270992651722805302190836346601270305667618834443905469417230011641435483045507686318400326189139005044865838051594081650882979920026360641078863266127457238472673530329066021406086739847509689671943753211591623950595625096120786816299022339572640835035166221636681928429438754847553405394582292153680771420358044486223577795514200358684092716839619110556801879241487166148305300812167494534788199826158698493290879716002235415208520290999476455680562126584364936301368181577024951075304387241571206936372935587571213830254606374665121781074158362849816045816194924038095180068470762331074899879296635488441961910479414714647494309783976832817203849602941093646062353007216698082554902701231256299784307239196973704379780378683046707066758912218833333151803159347580746561801887898429317279711644062843844455665291797452842584296246735042163181223195281544577764334464120470067333547068066664754861673701887509344330675190869975656179018342732519699389066854594562000762286064587750463294654495665361603819677705288911210656281862226611639626060800550545420440167966292069276285000232540198482731985962197589279500458712890588437963233227324398185287630490054460220838927943492000664085786568493364222240446822407915944168382134683926598299836764543626400395149236488702802421814596047448933635630977614344495895241020700671923048003206241425668624927544270525120395121651538677353170073455422283115797751343985673527784173620859510769132249968467044972485343879076132640017180188806608302196106389546887411306478871101765576886066557636360703728501420742187104714401745371482045248780076591138583746334017197092791373069897915363054261387251756084666299688595760488702310355086948130300940475709610853103930301390372896396580088532717895996450681685830103267938297337117635699105511509152947201347581878982242589305102081838906694499856879501395216395168370053857133893987820572122996552529420941538921510540963692678553400533271309042072584845766600926869918296507889616490161420097469883079228245292934279232670206158471430260043305305714908642340334500841621794379874584455667699472917975509631336409937005358812247278907582354235273679129767003343625939333209921253065748398115334605530443572461452447662507195304125797919022904035738408500313770351658174203059339637642204548603698802201213912622980831768959677566039331679858525486736772416560430025170085280677813553000181384056477086495574340135924283085514007515538542302370268804352426918053534603212581357269356723478460478332049635645";
        char[] char_num_table = rand_num_table.toCharArray();


        //The range of your subgroup.
        // for example  esl is       min = 1       max = 82
        //              gifted is    min = 83      max = 168
        System.out.println("subgroup lowest ID: ");
        int min = scan.nextInt();

        System.out.println("subgroup highest ID: ");
        int max = scan.nextInt();
        
        //how big you want your sample to be
        System.out.println("\nSample size: ");
        int size = scan.nextInt() + 1;

        //so that you can test if an ID number has already been picked or not
        String[] ending = new String[size];

        //starts at a random point on the table 
        int i = (int)Math.floor(Math.random() * ((char_num_table.length) + 1));
        int counter = 0;

        while (size != 0){
            String digits = "";
            i += 3;

            for(int j = 0; j < 3; j++){
                if (i + j >= char_num_table.length){
                    i = 0;
                }
                digits += char_num_table[i + j];
            }

            //if the number is in your range                                      and is not already in the ending array
            if ( min <= Integer.valueOf(digits) && Integer.valueOf(digits) <= max && !check(ending, digits)){
                ending[counter] = digits;
                size--;
                counter++;
            }
        }

        int[] real_ending = new int[ending.length];

        int a = 0;
        for (String number : ending){
            real_ending[a] = Integer.valueOf(number);
            a++;
        }
        Arrays.sort(real_ending);
        int z = 0;
        for (int number : real_ending){
            System.out.println(number);
            z++;
            if(z % 5 == 0){
                System.out.println("");
            }
        }
    }
}

/*
83 : 477,
84 : 498,
85 : 503,
86 : 504,
87 : 505,
88 : 506,
89 : 512,
90 : 514,
91 : 514,
92 : 517,
93 : 519,
94 : 529,
95 : 530,
96 : 562,
97 : 488,
98 : 491,
99 : 497,
100 : 502,
101 : 503,
102 : 504,
103 : 506,
104 : 514,
105 : 514,
106 : 517,
107 : 518,
108 : 519,
109 : 520,
110 : 524,
111 : 532,
112 : 482,
113 : 493,
114 : 496,
115 : 501,
116 : 503,
117 : 504,
118 : 507,
119 : 508,
120 : 509,
121 : 510,
122 : 519,
123 : 540,
124 : 541,
125 : 560,
126 : 488,
127 : 490,
128 : 502,
129 : 503,
130 : 510,
131 : 510,
132 : 517,
133 : 518,
134 : 520,
135 : 522,
136 : 524,
137 : 530,
138 : 532,
139 : 570,
140 : 488,
141 : 488,
142 : 490,
143 : 501,
144 : 501,
145 : 504,
146 : 509,
147 : 510,
148 : 513,
149 : 516,
150 : 517,
151 : 520,
152 : 520,
153 : 524,
154 : 530,
155 : 479,
156 : 488,
157 : 498,
158 : 500,
159 : 502,
160 : 504,
161 : 506,
162 : 507,
163 : 508,
164 : 510,
165 : 510,
166 : 512,
167 : 518,
168 : 530


169 F Koons Remedial 377
170 F Koons Remedial 398
171 F Koons Remedial 401
172 F Koons Remedial 403
173 F Koons Remedial 404
174 F Koons Remedial 412
175 F Koons Remedial 418
176 F Koons Remedial 419
177 F Koons Remedial 420
178 F Koons Remedial 425
179 F Koons Remedial 434
180 F Koons Remedial 441
181 F Koons Remedial 449
182 F Van Ness Remedial 379
183 F Van Ness Remedial 388
184 F Van Ness Remedial 401
185 F Van Ness Remedial 405
186 F Van Ness Remedial 408
187 F Van Ness Remedial 416
188 F Van Ness Remedial 417
189 F Van Ness Remedial 419
190 F Van Ness Remedial 419
191 F Van Ness Remedial 422
192 F Van Ness Remedial 422
193 F Van Ness Remedial 423
194 F Van Ness Remedial 430
195 F Wallace Remedial 379
196 F Wallace Remedial 382
197 F Wallace Remedial 398
198 F Wallace Remedial 399
199 F Wallace Remedial 400
200 F Wallace Remedial 403
201 F Wallace Remedial 407
202 F Wallace Remedial 410
203 F Wallace Remedial 410
204 F Wallace Remedial 415
205 F Wallace Remedial 416
206 F Wallace Remedial 420
207 F Wallace Remedial 429
208 M Koons Remedial 388
209 M Koons Remedial 396
210 M Koons Remedial 405
211 M Koons Remedial 416
212 M Koons Remedial 420
213 M Koons Remedial 427
214 M Koons Remedial 428
215 M Koons Remedial 430
216 M Koons Remedial 433
217 M Koons Remedial 450
218 M Koons Remedial 487
219 M Koons Remedial 491
220 M Koons Remedial 503
221 M Van Ness Remedial 382
222 M Van Ness Remedial 398
223 M Van Ness Remedial 399
224 M Van Ness Remedial 400
225 M Van Ness Remedial 403
226 M Van Ness Remedial 407
227 M Van Ness Remedial 410
228 M Van Ness Remedial 410
229 M Van Ness Remedial 415
230 M Van Ness Remedial 416
231 M Van Ness Remedial 420
232 M Van Ness Remedial 429
233 M Van Ness Remedial 439
234 M Wallace Remedial 388
235 M Wallace Remedial 396
236 M Wallace Remedial 405
237 M Wallace Remedial 419
238 M Wallace Remedial 420
239 M Wallace Remedial 427
240 M Wallace Remedial 428
241 M Wallace Remedial 433
242 M Wallace Remedial 439
243 M Wallace Remedial 450
244 M Wallace Remedial 487
245 M Wallace Remedial 491
246 M Wallace Remedial 503
*/