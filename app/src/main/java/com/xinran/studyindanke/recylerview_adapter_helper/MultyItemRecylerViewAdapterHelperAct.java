package com.xinran.studyindanke.recylerview_adapter_helper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xinran.studyindanke.R;
import com.xinran.studyindanke.recylerview_adapter_helper.adapter.MultiItemQuickAdapter;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.MultiItemBean;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by houqixin on 2018/2/8.
 * https://www.jianshu.com/p/1e20f301272e
 */

public class MultyItemRecylerViewAdapterHelperAct extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiItemQuickAdapter mAQuickAdapter;
    private View head0;
    private View fooder0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview_adapter_helper);
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_stu);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager
                .VERTICAL, false));
        mRecyclerView.setAdapter(mAQuickAdapter = new MultiItemQuickAdapter(mockSectionData()));

        setListner();

        setAnimation();

        operaterHeaderAndFooter();


    }

    @Override
    protected void onResume() {
        super.onResume();
       setLoadMoreListner();



        //setRefreshListner();
    }

    /**
     * 下拉刷新有点问题
     */

    private void setRefreshListner() {
        //可以下拉刷新
        mAQuickAdapter.setUpFetchEnable(true);
        mAQuickAdapter.setUpFetching(true);
        mAQuickAdapter.setEmptyView(R.layout.item_empty_view);
        mAQuickAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                mAQuickAdapter.addHeaderView(head0,0);
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //模拟网络环境
                        Random random=new Random();
                        mAQuickAdapter.setUpFetching(false);

                        int result= random.nextInt(4);
                        mAQuickAdapter.removeHeaderView(head0);
                        if(result==1){
                            mAQuickAdapter.setNewData(mockSectionData());
                        }else if(result==2){

                        }else if(result==3){
                            mAQuickAdapter.setNewData(mockSectionData());
                        }else{

                        }
                    }
                },1000);

            }
        });


    }

    private void setLoadMoreListner() {
        mAQuickAdapter.setEnableLoadMore(true);
        mAQuickAdapter.removeFooterView(fooder0);
        //如果不设置 有默认的
//        mAQuickAdapter.setLoadMoreView(new LoadMoreView() {
//            @Override
//            public int getLayoutId() {
//                return R.layout.view_load_more;
//            }
//
//            /**
//             * 如果返回true，数据全部加载完毕后会隐藏加载更多
//             * 如果返回false，数据全部加载完毕后会显示getLoadEndViewId()布局
//             */
//            @Override
//            public boolean isLoadEndGone() {
//                return true;
//            }
//
//            @Override
//            protected int getLoadingViewId() {
//                return R.id.load_more_loading_view;
//            }
//
//            @Override
//            protected int getLoadFailViewId() {
//                return R.id.load_more_load_fail_view;
//            }
//
//            /**
//             * isLoadEndGone()为true，可以返回0
//             * isLoadEndGone()为false，不能返回0
//             */
//            @Override
//            protected int getLoadEndViewId() {
//                return 0;
//            }
//
//        });
        mAQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                //模拟网络环境
                Random random=new Random();
               int result= random.nextInt(4);
                if(result==1){
                    mAQuickAdapter.addData(mockSectionData());
                    mAQuickAdapter.loadMoreComplete();
                }else if(result==2){
                    mAQuickAdapter.addData(mockSectionData());
                    mAQuickAdapter.loadMoreEnd();
                }else if(result==3){
                    mAQuickAdapter.loadMoreFail();
                }else{
                    mAQuickAdapter.addData(mockSectionData());
                    mAQuickAdapter.loadMoreComplete();
                }

            }
        },mRecyclerView);
    }

    private void operaterHeaderAndFooter() {

        head0=View.inflate(this,R.layout.item_header_view,null);
        fooder0=View.inflate(this,R.layout.item_footer_view,null);
        //Header 和Footer View都可以添加多了  也可以删除
       // mAQuickAdapter.addHeaderView(head0,0);

        mAQuickAdapter.addFooterView(fooder0);

//        final Handler handler=new Handler(new Handler.Callback() {
//            @Override
//            public boolean handleMessage(Message msg) {
//                if(msg.what==100){
//                    mAQuickAdapter.removeAllHeaderView();
////                    mAQuickAdapter.removeHeaderView(head0);
////                    mAQuickAdapter.removeAllFooterView();
//                }
//                return false;
//            }
//        });
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(100);
//
//            }
//        },2000);

        /**
         * 默认出现了头部就不会显示Empty，和尾部，配置以下方法也支持同时显示：
         mQuickAdapter.setHeaderAndEmpty()
         mQuickAdapter.setHeaderFooterEmpty();

         默认头部尾部都是占满一行，如果需要不占满可以配置：
         mQuickAdapter.setHeaderViewAsFlow();
         mQuickAdapter.setFooterViewAsFlow();

         */

    }

    private void setAnimation() {
        //开启动画（默认为渐显效果）
        // mAQuickAdapter.openLoadAnimation();
        /**
         * 该适配器提供了5种动画效果（渐显、缩放、从下到上，从左到右、从右到左）
         public static final int ALPHAIN = 0x00000001;

         public static final int SCALEIN = 0x00000002;

         public static final int SLIDEIN_BOTTOM = 0x00000003;

         public static final int SLIDEIN_LEFT = 0x00000004;

         public static final int SLIDEIN_RIGHT = 0x00000005;

         1.设置Item动画有可能看出不出来  所以可以在Adapter中重写startAnima方法 做下延迟

         2.注意：动画默认只执行一次，如果想重复执行可设置
         //设置重复执行动画
         adapter.isFirstOnly(false);
         */
        mAQuickAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);

        //自定义动画

//        mAQuickAdapter.openLoadAnimation(new BaseAnimation() {
//            @Override
//            public Animator[] getAnimators(View view) {
//                return new Animator[]{
//                        ObjectAnimator.ofFloat(view, "scaleY", 1, 0.5f, 1),
//                        ObjectAnimator.ofFloat(view, "scaleX", 1, 0.5f, 1)
//                };
//
//            }
//        });
    }


    private void setListner() {
        /**
         * item 设置监听事件
         *
         * 注意事项
         在嵌套recycleView的情况下需要使用你使用 adapter. setOnItemClickListener 来设置点击事件,如果使用recycleView
         .addOnItemTouchListener会累计添加的。
         */
        mAQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("点击了第" + position + "个");
            }
        });

        mAQuickAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                showToast("长按了第" + position + "个");
                return false;
            }
        });

        //为字view设置监听事件
        /**
         * 如果需要在子控件事件中获取其他子控件可以使用：
         adapter.getViewByPosition(RecyclerView recyclerView, int position, @IdRes int viewId)
         */

        mAQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int vId = view.getId();//以便设置了多了子view的点击事件 区分点击了那个
                if (vId == R.id.tv_name) {

                    TextView tv = (TextView) adapter.getViewByPosition(mRecyclerView, position,
                            vId);
                    tv.setText("点击了第" + position + "Name");
                }
            }
        });

        mAQuickAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter
                .OnItemChildLongClickListener() {


            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                int vId = view.getId();
                if (vId == R.id.tv_name) {

                    TextView tv = (TextView) adapter.getViewByPosition(mRecyclerView, position,
                            vId);
                    tv.setText("长按了第" + position + "Name");
                }
                return false;
            }
        });
    }


    private List<MultiItemBean> mockSectionData() {
        List<MultiItemBean> list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            MultiItemBean sectionBean=null;
            Student stu = new Student("Jack" + i, i);
            switch (i){
                case 0:
                case 3:
                case 6:
                case 9:
                case 12:
                    sectionBean=new MultiItemBean(MultiItemBean.TEXT_TYPE,stu);
                    break;
                default:
                    sectionBean=new MultiItemBean(MultiItemBean.IMG_TYPE,stu);
                    break;
            }
            list.add(sectionBean);
        }
        return list;
    }

    private void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
