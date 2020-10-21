<?php

namespace App\Http\Controllers;

use App\DataTables\ModeloAmbienteModeloEmbarcacaoDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateModeloAmbienteModeloEmbarcacaoRequest;
use App\Http\Requests\UpdateModeloAmbienteModeloEmbarcacaoRequest;
use App\Repositories\ModeloAmbienteModeloEmbarcacaoRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class ModeloAmbienteModeloEmbarcacaoController extends AppBaseController
{
    /** @var  ModeloAmbienteModeloEmbarcacaoRepository */
    private $modeloAmbienteModeloEmbarcacaoRepository;

    public function __construct(ModeloAmbienteModeloEmbarcacaoRepository $modeloAmbienteModeloEmbarcacaoRepo)
    {
        $this->modeloAmbienteModeloEmbarcacaoRepository = $modeloAmbienteModeloEmbarcacaoRepo;
    }

    /**
     * Display a listing of the ModeloAmbienteModeloEmbarcacao.
     *
     * @param ModeloAmbienteModeloEmbarcacaoDataTable $modeloAmbienteModeloEmbarcacaoDataTable
     * @return Response
     */
    public function index(ModeloAmbienteModeloEmbarcacaoDataTable $modeloAmbienteModeloEmbarcacaoDataTable)
    {
        return $modeloAmbienteModeloEmbarcacaoDataTable->render('modelo_ambiente_modelo_embarcacaos.index');
    }

    /**
     * Show the form for creating a new ModeloAmbienteModeloEmbarcacao.
     *
     * @return Response
     */
    public function create()
    {
        return view('modelo_ambiente_modelo_embarcacaos.create');
    }

    /**
     * Store a newly created ModeloAmbienteModeloEmbarcacao in storage.
     *
     * @param CreateModeloAmbienteModeloEmbarcacaoRequest $request
     *
     * @return Response
     */
    public function store(CreateModeloAmbienteModeloEmbarcacaoRequest $request)
    {
        $input = $request->all();

        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->create($input);

        Flash::success('Modelo Ambiente Modelo Embarcacao saved successfully.');

        return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
    }

    /**
     * Display the specified ModeloAmbienteModeloEmbarcacao.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
        }

        return view('modelo_ambiente_modelo_embarcacaos.show')->with('modeloAmbienteModeloEmbarcacao', $modeloAmbienteModeloEmbarcacao);
    }

    /**
     * Show the form for editing the specified ModeloAmbienteModeloEmbarcacao.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
        }

        return view('modelo_ambiente_modelo_embarcacaos.edit')->with('modeloAmbienteModeloEmbarcacao', $modeloAmbienteModeloEmbarcacao);
    }

    /**
     * Update the specified ModeloAmbienteModeloEmbarcacao in storage.
     *
     * @param  int              $id
     * @param UpdateModeloAmbienteModeloEmbarcacaoRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateModeloAmbienteModeloEmbarcacaoRequest $request)
    {
        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
        }

        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->update($request->all(), $id);

        Flash::success('Modelo Ambiente Modelo Embarcacao updated successfully.');

        return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
    }

    /**
     * Remove the specified ModeloAmbienteModeloEmbarcacao from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $modeloAmbienteModeloEmbarcacao = $this->modeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
        }

        $this->modeloAmbienteModeloEmbarcacaoRepository->delete($id);

        Flash::success('Modelo Ambiente Modelo Embarcacao deleted successfully.');

        return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
    }

    public function undelete($id)
    {
        $modeloAmbienteModeloEmbarcacao = DB::table('modelo_ambiente_modelo_embarcacao')
		    ->where('id', $id)->first();

        if (empty($modeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
        }

	    DB::table('modelo_ambiente_modelo_embarcacao')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Modelo Ambiente Modelo Embarcacao undeleted successfully.');

        return redirect(route('modeloAmbienteModeloEmbarcacaos.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('modelo_ambiente_modelo_embarcacao')
		    ->select(
				'modelo_ambiente_modelo_embarcacao.*'
				)
			->get();
	    return $lista;
    }
}
