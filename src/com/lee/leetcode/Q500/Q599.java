package com.lee.leetcode.Q500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Q599 {

//    599. 两个列表的最小索引总和
//    假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
//    你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
//
//    示例 1:
//
//    输入:
//            ["Shogun", "Tapioca Express", "Burger King", "KFC"]
//            ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//    输出: ["Shogun"]
//    解释: 他们唯一共同喜爱的餐厅是“Shogun”。
//    示例 2:
//
//    输入:
//            ["Shogun", "KFC", "Burger King", "Tapioca Express"]
//            ["KFC", "Shogun", "Burger King"]
//    输出: ["Shogun"]
//    解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1[0].equals(list2[0])){
            return new String[]{list1[0]};
        }
        List<String> result = new ArrayList<>();
        int index = Integer.MAX_VALUE;
        int length1 = list1.length;
        int length2 = list2.length;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if(i + j > index){
                    break;
                }
                if(list1[i].equals(list2[j])){
                    if(i + j < index){
                        index = i + j;
                        result.clear();
                    }
                    result.add(list1[i]);
                    break;
                }
            }
        }
        String[] strings = new String[result.size()];
        result.toArray(strings);
        return strings;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q599().findRestaurant(new String[]{"pjsxnfixtfllzdbxvhkklce","mpptawipkpbeumuundjohpfv","n","euyaisxprojsdnmy","jgnkeabofffhnmuxbcxoeam","aoec","wf","lnpc","iyuiotlhoiwht","yjanofkujucbh","vwsumbzaujrprpa","arrzcseqowhyrdswqvsnwqbyxk","lvzvehaqcvdqomzlnxcrrdfjvoqpa","waezlkklievjyw","fs","rmcrhrzlqwqfmbvgqpkifdqb","ccfroccyqnorynuj","vqesvgjfbzcnvkuqsdqdik","wfstyhpcqdjlhtjutj","wscdwcjstezqkweuu","s","kukjpnszcajfjcga","mcyrztqmxolosazczpyon","umuudilczexlumbgxiravwlqunxwi","ukoleeovrbcm","lmduwxxkiruosovpbppdyszkubyaup","ubzstkduopxvnfdvbirrdyxo","qhoweojwibga","gzbzaueukgfpvomhpqwkg","sjpvvxonlljnru","jhwakikylmxjmnbwdoguliwbfqbg","sgprhfsbprsdfymkiiq","inrjwwfqzyxhtjeihdkiaursomxs","gnkrnnz","uhlxgz","kgsbmumvfecjtayjmobc","kbdhzlqjfkubhtdoyhyckeovwlkwp","wfgoobxoyvjeuapaghy","hzgnujvwssegbcdcpokg","cejnkrwdukloocxpcntebcc","oioxybedmyt","styevnua","slwiybeh","rxkvjkssd","kcoehkfwchghrzwscnzyljv","iyxnltbwsvjvqbki","ryglorcjdieiownfrsucmxh","wbuinofkjgbyzyctlkmouidgsz","hiblkumgfyujsv","kqaigxwgerx","uhztzljcjfft","hkgtutwovemvlzigcqfrodoqfzowwa","dovqkmxmgtvbfonwps","iyqfxtnibqgb","eytbxzzqfzmsiqcsihkhlyisqghy","omtvrathvrvuxiiigfobdhpdtl","nvxyri","ny","qmrcwijyzzsarzjstngdbxvnnw","vornsjsyelzcqaf","zvkkmix","pjxtq","qnpoo","sxzwglzjiboksbtaiplucwfslhbnc","zzxeq","zpa","gpcwyymtcmwwpwmkhdv","fzzvgycpgimiwamhevicj","rngjwdudbsmbzcnawgfgndnxxxl","xobnyosajckvhhcewbpoo","iaxyaxwdryjcqczbirrbm","yxvuuewhnth","rkwyvjgrsyeoqgfumilcdckhnrdxl","fnpwenrmqzxaeqpnwplioucm","fyrvdnusktzeoqyzykodmfnftkfv","rcxtzpwhypixgnjgkyhpq","qdsifktgepac","uepohimlqrxaiinijxyedjb","vpgkklbwnriznycsxnbel","hcectziwxz","kwnoknnpvsbsogqckfbhafyjcutpe","vsu","kerkpatqekg","nxqlrcytplyycymvuhzzcn","zgneictmv","iladhoguuwegee","ohnymwibnbhdvxtkpqb","iqw","etis","zmsdscfoeqosscyukahmuqrytl","gzwoeidzrgvujizbnzojgn","fwzlgtocyzercoysnmbq","igenrlgjygtemjzaknp","x","ahdwvdfbenrsjiworfvouwj","yseh","zzn","wxbgzcufbtriuxwzuouktbquqpuuz","rasqxqlqlfofxtrzlldp","qus","qqirbieevpgwihzl","kuqtmpadrboqwnoahd","pbffplskkgzndlhspvjrk","hsqzshmfrdku","emmxtmhgcdnhnrvx","bhpbczbnuvdcsvvdhgfk","hetvcd","ccajaqqemvwhubarhhskqzfox","xeplhnjbexkfvhxu","tqfuqyvfoijlyo","fgvphqlsrjxpyeticpoafvmnfgqka","ifoxjxkabmzcrkyjx","lgihaa","bxqzen","wbatlpbdxjiwmkbtjxvqmrmyeh","bgigrzaalldlcwsquqxdfwaok","gxwwdrbcelagvhofygs","yybcwnayagcmlhdggj","gehjhnkeut","xgdleeiwilxlfkd","qjuksqogndg","izbpjwbktczuglloswkyajcauczlh","wrwyunxzpyhpibcwuw","xaeqcyvcjxytuneor","unsntckgcrdxtdssiojpi","hmfgqkkafeqepf","hjhywjlxlfzjuydmbpfeoojxuxnuz","gibftesqxuhejxlwwvwuoyitfqyq","owfgyqcqvmlyrrgjfmqjqsiz","ncpzoxbhvlnqkrqecboxhif","yuvrhevbsrxk","vafbpkkueovngajjdx","ims","lhotqex","ojbbvmnjdxl","niaqacckxdvrci","v","kwijquhxxhmilsejmvm","vcpdqqisqaniryctf","vkxwoblgtiwaciwtjplblhxagmvu","mubjisvcuiocmj","yeopwxqkwtafznnsksyqxdtlgdoxlq","zubxgstymfyqfhfjcavewnsrnuqdiq","ycxninetndidwi","iwosrjdj","bnwboe","fynfqivxjqaicbslinpa","wrilxoheemgz","csr","runjaqymhiyqxjnrwjqwschhoaxtm","uxwjksmuitiqytzmawqswyv","mbrtvaiiepkvq","jhihmynfgpigvvopoaagxsyk","gsfcndxnmlviblazlyuzt","giczqqsghbxaowilmrhcvjakwfgnp","zctxapdwvbtxownusmhsal","ipcustjo","gimmmsufgvmgmlvjwagyxgadjirgog","ryehrja","qiishewhgouzyvg","tkbdtsurqqjlqnimpl","bjvxiodqwluinwnehshrtznsae","opoxrivaqszrmbdljiqdmebxtsto","yvzjmcdrcimgcremhdsheonldaotdd","sm","jvqhaw","txnmuhxviyntbrjqdgacrnilxyrl","dcnfwcoucssqn","gewuvdqthvoflbcafy","jbhxoghmrfqbyhvtqczywbhakxbpt","bolqexf","jmcrqadzaavybx","hiuonaxqsunkoi","uoiqpzkxbwgspskdqbdllfdrz","tvxgas","wfkmxkaqhcigqfgecqdkkbzmdnb","nagnrdygryxspebzbvzyfwbfscqvv","cwkhfxvhomsxnmfzafeaqguzwrghb","mvyczchiyfojaifgfczvj","myfwkunrtcqmzpwfahhfduyxmr","otuqrkeceapckzxo","gbaqyrekejoyjaazbfjg","gbayibpxzcucvkvaherf","utpha","nhtdptctqcplxnndkmlodljrxrybh","qq","udwiqajczlvoorfjvtbahqsrr","evwuuwybrhirdowxymjcdknxpkv","livhvggtgkygztkhvzm","whwhatvankphsaberuavy","py","omgfyrbsicq","smqmjvtoyaxdoswitipnzfxrhwux","ftmpcnqgqltk","dbmtiavlvndaunftbwhktpm","cbdkdasidya","qaqdeigywviwxzkpolfz","qnqtwghzpwixezxzsctwyn","xkpizw","rtcndnugvmcwkzvuumukpigbboxess","fcsyqrhyirhqybbteeubz","mrmbpamxkjdowhmuphflyue","ymum","fnhjvudyihpiviyhgn","nmclpeavwqo","pjtfuhw"},
                new String[]{"vcuiailhytfcwrwskoszykzndm","vcpdqqisqaniryctf","sfcjzhi","zytuqcfd","niaqacckxdvrci","ojbbvmnjdxl","lpibxquhza","btpzedqbavjthlvtzwvlrkhfajek","kpqsemyimejtuzfm","cvnl","jjkqx","cblrqjrumbarqztwdayicnjt","gibftesqxuhejxlwwvwuoyitfqyq","hjhywjlxlfzjuydmbpfeoojxuxnuz","hmfgqkkafeqepf","isue","xaeqcyvcjxytuneor","wrwyunxzpyhpibcwuw","izbpjwbktczuglloswkyajcauczlh","qjuksqogndg","xgdleeiwilxlfkd","nxxvvzdcxatlmodnuopudnsjkoxqp","yybcwnayagcmlhdggj","gxwwdrbcelagvhofygs","bgigrzaalldlcwsquqxdfwaok","wbatlpbdxjiwmkbtjxvqmrmyeh","bfpcostiwfinli","hxdwo","jqz","xuomaclvpfpdijxhwpewmiwolge","tqfuqyvfoijlyo","tsiemqwstodqtebd","nectmxvmclpgi"})));

    }
}
